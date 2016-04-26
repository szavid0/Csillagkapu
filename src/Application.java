
import java.io.*;
class Application {
	
	static BufferedReader br;
	static int i = 0;
	static boolean checklog(Integer testnum) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("teszt_"+testnum+".txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("log.txt"));
        String line=br.readLine();
        while(!line.isEmpty())
            line = br.readLine();
       
        String logline;
        while((line = br.readLine()) != null){
            logline=br2.readLine();
            if(!line.equals(logline)){
                br.close();
                br2.close();
                return false;
            }
        }
        br.close();
        br2.close();
        return true;
    }

	static void loadMap() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("map.txt"));
		while(true){
			String line=br.readLine();
			if(line == null)
				break;
			String[] palyaelem=line.split(" ");
			String[] koordinatak=palyaelem[0].split(":");
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
				StarGate yellow = new StarGate(89,t,Direction.WEST,Color.YELLOW,true);
				LabirinthManager.yellowStarGate=yellow;
				maze.addBlock(yellow);
				break;
			}
			case "BLUE_STARGATE":{
				int poz=Integer.parseInt(koordinatak[0]);
				int t[]=new int[4];
				t[0]=poz-10;
				t[1]=poz+10;
				t[2]=poz+1;
				t[3]=poz-1;
				StarGate blue = new StarGate(50,t,Direction.EAST,Color.BLUE,true);
				LabirinthManager.blueStarGate=blue;
				maze.addBlock(blue);
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
		
		String line = new String();
		if(testnum < 12){
			br = new BufferedReader(new FileReader("teszt_" + testnum.toString() + ".txt"));
			for(int i = 0; !(line = br.readLine()).equals(""); i++){
				processCommand(line, testnum);
			}
		}else{
			br = new BufferedReader(new InputStreamReader(System.in));		//Manual mod
			System.out.println("MANUAL MOD - ENTER STATUSZ FOR FULLSTATUSZ");
			System.out.println("\nNEW GAME STARTED");
			log.println("NEW GAME STARTED");
			loadMap();
			general = new General(maze.getBlock(52),Direction.EAST,true);
			jaffa = new Jaffa(maze.getBlock(27), Direction.WEST,true);
			replicator = new Replicator(maze.getBlock(77),Direction.NORTH);
			System.out.println("GENERAL,52,EAST\nJAFFA,27,WEST\nREPLICATOR,77,NORTH\n");
			log.println("GENERAL,52,EAST\nJAFFA,27,WEST\nREPLICATOR,77,NORTH");

			
			for(int i = 0; !(line = br.readLine()).equals("EXIT"); i++){	//EXIT PARANCS
				processCommand(line, testnum);
			}
		}
		log.close();
	
	}
	public static void processCommand(String line,Integer testnum) throws IOException{
		String[] command;
		
			if(i<3 && testnum != 12){		//karakter inicializ�l�s, csak f�jlb�l olvas�s eset�n
			String[] parts = line.split(",");
			if(parts[0].equals("GENERAL")){
				if(parts.length == 4){
					general = new General(maze.getBlock(Integer.parseInt(parts[1])), stringToDirection(parts[2]),true);
				}
					else
					general = new General(maze.getBlock(Integer.parseInt(parts[1])), stringToDirection(parts[2]),false);

			}
			if(parts[0].equals("JAFFA")){
				if(parts.length == 4)
					jaffa = new Jaffa(maze.getBlock(Integer.parseInt(parts[1])), stringToDirection(parts[2]),true);
				else 
					jaffa = new Jaffa(maze.getBlock(Integer.parseInt(parts[1])), stringToDirection(parts[2]),false);

			}
			if(parts[0].equals("REPLICATOR")){
				replicator = new Replicator(maze.getBlock(Integer.parseInt(parts[1])), stringToDirection(parts[2]));
			}
		}
		i++;

		String character = new String();
		
		//itt a parancsokn�l mindegyiket k�l�n meg kell val�s�tani
		command = line.split(" ");
		switch (command[0]){
		case "NEW": 
			System.out.println("NEW GAME STARTED");
			log.println("NEW GAME STARTED");
			loadMap();
			break;
		case "RANDOM":
			if(command[1].equals("ON")){
				System.out.println("RANDOM MODE ON");
				log.println("RANDOM MODE ON");
			}
			if(command[1].equals("OFF")){
				System.out.println("RANDOM MODE OFF");
				log.println("RANDOM MODE OFF");
			}
			break;
		case "MULTI-THREAD":			//Tobbszalusag ki/bekapcsolasa. Nincs meg megvalositva.
			if(command[1].equals("ON")){
				System.out.println("MULTI-THREAD MODE ON");
				log.println("MULTI-THREAD MODE ON");
			}
			if(command[1].equals("OFF")){		
				System.out.println("MULTI-THREAD MODE OFF");
				log.println("MULTI-THREAD MODE OFF");
			}
			break;
		case "SET":
			
			if(command.length != 4)	System.out.println("Invalid command! Usage: SET GENERAL DIRECTION WEST");
			else{
				if(command[1].equals("GENERAL")){
					character = "GENERAL";
					general.setDirection(stringToDirection(command[3]));
				}
					
				if(command[1].equals("JAFFA")){
					jaffa.setDirection(stringToDirection(command[3]));
				}if(command[1].equals("REPLICATOR")){
					replicator.setDirection(stringToDirection(command[3]));
				}
			}
			break;
		case "PICK":
			if(command.length != 2)	System.out.println("Invalid command! Usage: GENERAL PICK");
			else{
				if(command[1].equals("GENERAL")){
						character = "GENERAL";
						general.pick();
					}
					
					if(command[1].equals("JAFFA")){
						character = "JAFFA";
						jaffa.pick();
					}
			}	
			break;
		case "SHOOT":
			if(command.length == 3){
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
			}else{
				System.out.println("Invalid command! Usage: SHOOT GENERAL YELLOW");
			}
			break;
		case "DROP":
			if(command.length != 2)System.out.println("Invalid command! Usage: DROP JAFFA");
			else{
				if(command[1].equals("GENERAL")){
						character = "GENERAL";
						general.drop();
					}
					
					if(command[1].equals("JAFFA")){
						character = "JAFFA";
						jaffa.drop();
					}
			}		
			
			break;
		case "SAVE":
			System.out.println("GAME SAVED"); 
			log.println("GAME SAVED"); 
			break;
		case "MOVE":
			if(command.length != 3)System.out.println("Invalid command! Usage: MOVE GENERAL WEST");
			else{
			if(command[1].equals("GENERAL")){
				character = "GENERAL";
				general.move(stringToDirection(command[2]));
			}
			
			if(command[1].equals("JAFFA")){
				character = "JAFFA";
				jaffa.move(stringToDirection(command[2]));
			}
			if(command[1].equals("REPLICATOR")){
				character = "REPLICATOR";
				if(replicator != null)
					replicator.move(stringToDirection(command[2]));
				else{
					System.out.println("REPLICATOR IS NULL");
				}
				
				
				}
			}
			break;
		case "STATUSZ":
				fullStatusz();
			break;
		default: 
			break;
		
	}
}


	//az�rt staticok, mert csak egy l�tezik bel�l�k.
	public static General general = new General();
	public static Replicator replicator = new Replicator();
	public static Jaffa jaffa = new Jaffa();
	public static PrintWriter log;
	public static LabirinthManager maze = new LabirinthManager();
	
	public static void main(String[] args) throws IOException{
		
		File logFile=new File("log.txt");
	    log = new PrintWriter(new FileWriter(logFile));
		
		System.out.println("---------------------------------------------------------");
		System.out.println("|   			PROTOTIPUS MENU\t						|");
		System.out.println("---------------------------------------------------------");
		System.out.println("|	1.Iranyvaltas\t\t\t\t\t|");
		System.out.println("|	2.Lepes mezore,ZPM felvetele,Uj ZPM keletkezese|");
		System.out.println("|	3.Lepes Merlegre\t\t\t\t|");
		System.out.println("|	4.Lepes Ajtora\t\t\t\t\t|");
		System.out.println("|	5.Lepes Szakadekra\t\t\t\t|");
		System.out.println("|	6.Lepes Csillagkapura\t\t\t\t|");
		System.out.println("|	7.Doboz lerakasa\t\t\t\t|");
		System.out.println("|	8.Doboz felvetele\t\t\t\t|");
		System.out.println("|	9.Loves falra\t\t\t\t\t|");
		System.out.println("|	10.Loves csillagkapura\t\t\t\t|");
		System.out.println("|	11.Replikatort lelovik\t\t\t\t|");
		System.out.println("|	12.Parancsok bevitele konzolrol\t\t\t\t|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Valassz egy tesztesetet es ird be a szamat!");
		
		loadMap();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		i = Integer.parseInt(in.readLine());
		runPrototype(i);
		if(i != 12)
			if(checklog(i)){
				System.out.println("Success");
			}
			else
				System.out.println("Failure");
		log.close();
	}
	
	public static void endGame(String winOrLose){
		System.out.println(winOrLose);
	}
	public static void fullStatusz(){
		if(replicator != null)
			System.out.println("\n"+general+"\n"+jaffa+"\n"+replicator);
		else{
			System.out.println("\n"+general+"\n"+jaffa+"\n"+"REPLICATOR:NULL");

		}
		maze.listStatusz();
	}
}


