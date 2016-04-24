import java.io.*;
class Application {
	
	/**
	 * A 
	 */
	static void loadMap() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("map.txt"));
		while(true){
			String line=br.readLine();
			if(line == null)
				break;
			String[] palyaelem=line.split(" ");
			String[] koordinatak=palyaelem[0].split(":");
			System.out.println(line);
			switch(palyaelem[1]){
			case "WALL":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Wall(i,t,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Wall(poz,t,false));
				}
				break;
			case "SPECIAL_WALL":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Wall(i,t,true));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Wall(poz,t,true));
				}
				break;
			case "FIELD":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,false,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,false,false));
				}
				break;
			case "FIELD_ZPM":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,false,true));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,false,true));
				}
				break;
			case "FIELD_BOX":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,true,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,true,false));
				}
				break;
			case "DOOR":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Door(i,t));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Door(poz,t));
				}
				break;
			case "CANYON":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-10;
						t[1]=i+10;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Canyon(i,t));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-10;
					t[1]=poz+10;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Canyon(poz,t));
				}
				break;
			case "YELLOW_STARGATE":{
				int poz=Integer.parseInt(koordinatak[0]);
				int t[]=new int[4];
				t[0]=poz-10;
				t[1]=poz+10;
				t[2]=poz+1;
				t[3]=poz-1;
				maze.addBlock(new StarGate(poz,t,Direction.WEST,Color.YELLOW,true));
				break;
			}
			case "BLUE_STARGATE":{
				int poz=Integer.parseInt(koordinatak[0]);
				int t[]=new int[4];
				t[0]=poz-10;
				t[1]=poz+10;
				t[2]=poz+1;
				t[3]=poz-1;
				maze.addBlock(new StarGate(poz,t,Direction.WEST,Color.YELLOW,true));
				break;
			}
			case "SCALE":{
				int poz=Integer.parseInt(koordinatak[0]);
				int t[]=new int[4];
				t[0]=poz-10;
				t[1]=poz+10;
				t[2]=poz+1;
				t[3]=poz-1;
				String[] doorweight=br.readLine().split(" ");
				maze.addBlock(new Scale(poz,t,(Door)maze.getBlock(Integer.parseInt(doorweight[0])),Integer.parseInt(doorweight[1]),false,false));
				break;
			}
			}
			//maze.createWormHole(Color.YELLOW);
		}
		br.close();
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
			if (i == 0 || i == 1) {
				String[] parts = line.split(",");
				if(parts[0].equals("GENERAL")){
					general.setPosBlock(maze.getBlock(Integer.parseInt(parts[1])));
					general.setDirection(stringToDirection(parts[2]));
				}
				if(parts[0].equals("JAFFA")){
					jaffa.setPosBlock(maze.getBlock(Integer.parseInt(parts[1])));
					jaffa.setDirection(stringToDirection(parts[2]));
				}
			}
			
			String character = new String();
			
			//itt a parancsoknál mindegyiket külön meg kell valósítani
			command = line.split(" ");
			switch (command[0]){
			case "NEW GAME": loadMap(); break;
			case "RANDOM":
				if(command[1].equals("ON")){
					System.out.println("RANDOM MODE ON");
					log.write("RANDOM MODE ON");
				}
				if(command[1].equals("OFF")){
					System.out.println("RANDOM MODE OFF");
					log.write("RANDOM MODE OFF");
				}
				break;
			case "MULTI-THREAD":
				if(command[1].equals("ON")){
					System.out.println("MULTI-THREAD MODE ON");
					log.write("MULTI-THREAD MODE ON");
				}
				if(command[1].equals("OFF")){
					System.out.println("MULTI-THREAD MODE OFF");
					log.write("MULTI-THREAD MODE OFF");
				}
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
			case "SAVE":
				System.out.println("GAME SAVED"); 
				log.write("GAME SAVED"); 
				break;
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
	public static BufferedWriter log;
	public static LabirinthManager maze = new LabirinthManager();
	
	public static void main(String[] args) throws IOException{
		
		File logFile=new File("log.txt");
	    log = new BufferedWriter(new FileWriter(logFile));
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|   			PROTOTIPUS MENU\t						|");
		System.out.println("---------------------------------------------------------");
		System.out.println("|	1.Lepes Mezore,ZPM felvetele,Uj ZPM keletkezese|");
		System.out.println("|	2.Lepes Merlegre\t\t\t\t|");
		System.out.println("|	3.Lepes Ajtora\t\t\t\t\t|");
		System.out.println("|	4.Lepes Szakadekra\t\t\t\t|");
		System.out.println("|	5.Lepes Csillagkapura\t\t\t\t|");
		System.out.println("|	6.Doboz lerakasa\t\t\t\t|");
		System.out.println("|	7.Doboz felvetele\t\t\t\t|");
		System.out.println("|	8.Loves falra\t\t\t\t\t|");
		System.out.println("|	9.Loves csillagkapura\t\t\t\t|");
		System.out.println("|	10.Replikatort lelovik\t\t\t\t|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Valassz egy tesztesetet es ird be a szamat!");
		
		loadMap();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		i = Integer.parseInt(in.readLine());
		general = new General();
		jaffa = new Jaffa();
		runPrototype(i);
	}
	
	public static void endGame(String winOrLose){
		System.out.println(winOrLose);
	}
}

