import java.io.*;
class Application {
	
	/**
	 * A térképbetöltésnek ez a függvénye.
	 */
	static void loadMap(){
		//TODO
	}
	
	static Direction stringToDirection(String dir){
		switch(dir){
		case "WEST": return Direction.WEST;
		case "EAST": return Direction.EAST;
		case "NORTH": return Direction.NORTH;
		case "SOUTH": return Direction.SOUTH;
		default: return Direction.NORTH;
		}
	}
	
	static void runPrototype(Integer testnum) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new FileReader("teszt_" + testnum.toString() + ".txt"));
		String line = new String();
		String[] command;
		
		for(int i = 0; (line = br.readLine()) != null; i++){
			if (i == 0) {
				String[] parts = line.split(",");
				general.setPosBlock(maze.getBlock(Integer.parseInt(parts[0])));
				general.setDirection(stringToDirection(parts[1]));
			}
			
			if(i == 1){
				if(line.equals("NEW GAME")){
					loadMap();
				}
			}
			
			String character = new String();
			
			//itt a parancsoknál mindegyiket külön meg kell valósítani
			command = line.split(" ");
			switch (command[0]){
			case "RANDOM":
				if(command[1].equals("ON"))
					System.out.println("RANDOM MODE ON");
				if(command[1].equals("OFF"))
					System.out.println("RANDOM MODE OFF");
				break;
			case "MULTI-THREAD":
				if(command[1].equals("ON"))
					System.out.println("MULTI-THREAD MODE ON");
				if(command[1].equals("OFF"))
					System.out.println("MULTI-THREAD MODE OFF");
				break;
			case "SET":
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					general.setDirection(stringToDirection(command[3]));
				}
					
				if(command[1].equals("JAFFA")){
					jaffa.setDirection(stringToDirection(command[3]));
				}
				break;
			case "PICK":
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					general.pick();
				}
				
				if(command[1].equals("JAFFA")){
					character = "JAFFA";
					jaffa.pick();
				}
				break;
			case "SHOOT":
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					if(command[2].equals("BLUE"))
						general.shoot(Color.BLUE);
					if(command[2].equals("YELLOW"))
						general.shoot(Color.YELLOW);
					}
					
				if(command[1].equals("JAFFA")){
						character = "JAFFA";
						if(command[2].equals("RED"))
							jaffa.shoot(Color.RED);
						if(command[2].equals("GREEN"))
							jaffa.shoot(Color.GREEN);
					}
					break;
			case "DROP":
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					general.drop();
				}
				
				if(command[1].equals("JAFFA")){
					character = "JAFFA";
					jaffa.drop();
				}
				break;
			case "SAVE"://TODO
			case "MOVE":
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					general.move(stringToDirection(command[2]));
				}
				
				if(command[1].equals("JAFFA")){
					character = "JAFFA";
					jaffa.move(stringToDirection(command[2]));
				}
			default:
			}
		}
	}


	//azért staticok, mert csak egy létezik belőlük.
	public static General general = new General();
	public static Replicator replicator = new Replicator();
	public static Jaffa jaffa;
	
	public static LabirinthManager maze;	
	public static void main(String[] args) throws IOException{
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|   			PROTOTÍPUS MENU\t|");
		System.out.println("---------------------------------------------------------");
		System.out.println("|	1.Lépés mezőre, ZPM felvétele, új ZPM keletkezése|");
		System.out.println("|	2.Lépés Mérlegre\t\t\t\t|");
		System.out.println("|	3.Lépés Ajtóra\t\t\t\t\t|");
		System.out.println("|	4.Lépés Szakadékra\t\t\t\t|");
		System.out.println("|	5.Lépés Csillagkapura\t\t\t\t|");
		System.out.println("|	6.Doboz lerakása\t\t\t\t|");
		System.out.println("|	7.Doboz felvétele\t\t\t\t|");
		System.out.println("|	8.Lövés falra\t\t\t\t\t|");
		System.out.println("|	9.Lövés csillagkapura\t\t\t\t|");
		System.out.println("|	10.Replikátort lelövik\t\t\t\t|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Valassz egy tesztesetet es ird be a szamat!");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		i = Integer.parseInt(in.readLine());
		general = new General();
			
		/*
		// Switch construct
		switch (i) {
		case 1:
		  System.out.println("Option 1 selected");
		  maze = new LabirinthManager(1);
		  general.move(Direction.WEST);
		  break;
		case 2:
		  System.out.println("Option 2 selected");
		  maze = new LabirinthManager(2);
		  general.setDirection(Direction.WEST);
		  general.drop();
		  break;
		case 3:
		  System.out.println("Option 3 selected");
		  maze = new LabirinthManager(3);
		  general.move(Direction.WEST);
		  break;
		case 4:
		  System.out.println("Option 4 selected");
		  maze = new LabirinthManager(4);
		  general.pick();
		  break;
		case 5:
		  System.out.println("Option 5 selected");
		  maze = new LabirinthManager(5);
		  general.drop();
		  break;
		case 6:
		  System.out.println("Option 6 selected");
		  maze = new LabirinthManager(6);
		  general.pick();
		  break;
		case 7:
		  System.out.println("Option 7 selected");
		  maze = new LabirinthManager(7);
		  general.drop();
		  break;
		case 8:
		  System.out.println("Option 8 selected");
		  maze = new LabirinthManager(8);
		  general.move(Direction.WEST);
		  break;
		case 9:
		  System.out.println("Option 9 selected");
		  maze = new LabirinthManager(9);
		  general.move(Direction.WEST);
		  break;
		case 10:
		  System.out.println("Option 10 selected");
		  maze = new LabirinthManager(10);
		  general.shoot(Color.YELLOW);
		  break;
		case 11:
		  System.out.println("Option 11 selected");
		  maze = new LabirinthManager(11);
		  general.shoot(Color.YELLOW);
		  break;
		case 12:
		  System.out.println("Option 12 selected");
		  maze = new LabirinthManager(12);
		  general.shoot(Color.BLUE);
		  break;
		case 13:
		  System.out.println("Option 13 selected");
		  maze = new LabirinthManager(13);
		  general.move(Direction.WEST);
		  break;
		case 14:
		  System.out.println("Option 14 selected");
		  maze = new LabirinthManager(14);
		  general.move(Direction.EAST);
		  break;  
		case 15:
		  System.out.println("Exit selected");
		  break;           
		default:
		  System.out.println("Invalid selection");
		  break; // This break is not really necessary
		}*/
	}
	public static void endGame(String winOrLose){
		System.out.println("Application.endGame(" + winOrLose + ")");
	}
}

