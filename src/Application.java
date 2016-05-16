
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Application extends JFrame{
	
	private static BufferedReader br;
	private static int i = 0;
	private static int mapWidth = 10;  //csak tesztpalya felepitese miatt kell
	static boolean random = false;
	public static Graphics g;
	
	//teszt kimenet ellenorzese
	//a log fajl tartalmat veti ossze az elvart kimenettel	
	static boolean checklog(Integer testnum) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("teszt_"+testnum+".txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("log.txt"));
        String line=br.readLine();
        while(!line.isEmpty())
            line = br.readLine();
     
        //soronkent tortenik az osszehasonlitas
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

	//Palya betoltese a map.txt fajlbol
	//palyaelemenkent beallitja a szomszedokat es az egyedi blokktulajdonsagokat
	//majd hozzaadja a map-hoz
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
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Wall(i,t,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Wall(poz,t,false));
				}
				break;
			case "SPECIAL_WALL":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Wall(i,t,true));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Wall(poz,t,true));
				}
				break;
			case "FIELD":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,false,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,false,false));
				}
				break;
			case "FIELD_ZPM":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,false,true));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,false,true));
				}
				break;
			case "FIELD_BOX":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Field(i,t,true,false));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Field(poz,t,true,false));
				}
				break;
			case "DOOR":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Door(i,t));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Door(poz,t));
				}
				break;
			case "CANYON":
				if(koordinatak.length==2){
					for(int i=Integer.parseInt(koordinatak[0]);i<=Integer.parseInt(koordinatak[1]);i++){
						int t[]=new int[4];
						t[0]=i-mapWidth;
						t[1]=i+mapWidth;
						t[2]=i+1;
						t[3]=i-1;
						maze.addBlock(new Canyon(i,t));
					}
				}
				else{
					int poz=Integer.parseInt(koordinatak[0]);
					int t[]=new int[4];
					t[0]=poz-mapWidth;
					t[1]=poz+mapWidth;
					t[2]=poz+1;
					t[3]=poz-1;
					maze.addBlock(new Canyon(poz,t));
				}
				break;
			case "YELLOW_STARGATE":{
				int poz=Integer.parseInt(koordinatak[0]);
				int t[]=new int[4];
				t[0]=poz-mapWidth;
				t[1]=poz+mapWidth;
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
				t[0]=poz-mapWidth;
				t[1]=poz+mapWidth;
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
				t[0]=poz-mapWidth;
				t[1]=poz+mapWidth;
				t[2]=poz+1;
				t[3]=poz-1;
				String[] doorweight=br.readLine().split(" ");
				maze.addBlock(new Scale(poz,t,(Door)maze.getBlock(Integer.parseInt(doorweight[0])),Integer.parseInt(doorweight[1]),false,false));
				break;
			}
			}
		}
		br.close();
		Controller.Update();//frissítjük!
	}
	
	//azért staticok, mert csak egy létezik belõlük.
	public static General general = new General();
	public static Replicator replicator = new Replicator();
	public static Jaffa jaffa = new Jaffa();
	public static PrintWriter log;
	public static LabirinthManager maze = new LabirinthManager();
	
	private KeyListener myKeyListener = new KeyListener(){

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Pressed "+ e.getKeyCode());
			switch(e.getKeyCode()){
			case 87: jaffa.move(Direction.NORTH);break;  //W
			case 65: jaffa.move(Direction.WEST);break;	//A
			case 83: jaffa.move(Direction.SOUTH);break;	//S
			case 68: jaffa.move(Direction.EAST);break;	//D
			case 81: jaffa.shoot(Color.RED);break;	//Q - jaffa shoot red
			case 69: jaffa.shoot(Color.GREEN);break;	//E - jaffa shoot green
			case 70: jaffa.pick();break;	//F - jaffa pick
			case 71: jaffa.drop();break;	//G - jaffa drop
			
			case 38: general.move(Direction.NORTH);break;	//up-arrow
			case 37: general.move(Direction.WEST);break;	//left-arrow
			case 40: general.move(Direction.SOUTH);break;	//down-arrow
			case 39: general.move(Direction.EAST);break;	//right-arrow
			case 17: general.shoot(Color.BLUE);break;	//right-ctrl - general shoot blue
			case 16: general.shoot(Color.YELLOW);break;	//right-shift - general shoot yellow
			case 97: general.pick();break;  //1 - general pick
			case 98: general.drop();break; //2 - general drop
			}
		}	

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
		
	};
	
	private ActionListener newgameListener = new ActionListener(){

		/**
		 * Uj jatek inditasa,
		 * palya betoltese, karakterek inicalizalasa
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			//uj panel aktivalasa
			container.setVisible(false);
			gamePanel.setBackground(new java.awt.Color(25,35,125));
			app.add(gamePanel);
			gamePanel.setFocusable(true);
			gamePanel.requestFocusInWindow();
			gamePanel.addKeyListener(myKeyListener);
			try {
				loadMap();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			general = new General(maze.getRandomEmptyField(),Direction.EAST,false);
			jaffa = new Jaffa(maze.getRandomEmptyField(), Direction.WEST,false);
			replicator = new Replicator(maze.getRandomEmptyField(),Direction.NORTH);
			System.out.println(general+"\n"+jaffa+"\n"+replicator);					
		}
		
	};
	private ActionListener exitListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	};
	//Swing elemek
	private JButton newgame = new JButton("New Game");
	private JButton loadgame = new JButton("Load Game");
	private JButton exit = new JButton("EXIT");
	private JPanel panel = new JPanel();
	private JPanel container = new JPanel();
	private JPanel gamePanel = new JPanel();
	private static Application app;

	
	public Application(){
		setSize(600, 600);
		setTitle("GAME of STARGATE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		container.setLayout(new BorderLayout());
		panel.setSize(400,600);
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panel.setBackground(new java.awt.Color(25,35,125));
		
		//header,bg
		JLabel header = new JLabel("GAME of STARGATE");
		JPanel headerPanel = new JPanel();
		headerPanel.setSize(400,180);
		headerPanel.setBackground(new java.awt.Color(25,35,125));
		panel.add(Box.createRigidArea(new Dimension(0, 50)));
		panel.setBackground(new java.awt.Color(25,35,125));
		header.setFont(new Font("Arial",Font.BOLD,35));
		header.setForeground(java.awt.Color.yellow);
		headerPanel.add(header);
		panel.add(headerPanel);
		
		//body
		JPanel body = new JPanel();
		body.setSize(400, 420);
		body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
		body.setBackground(new java.awt.Color(25,35,125));
		newgame.setFont(new Font("Arial",Font.PLAIN,20));
		newgame.setForeground(new java.awt.Color(25,35,125));
		loadgame.setFont(new Font("Arial",Font.PLAIN,20));
		loadgame.setForeground(new java.awt.Color(0,145,90));
		
		JPanel bodyFirsLine = new JPanel();
		bodyFirsLine.setLayout(new FlowLayout());
		bodyFirsLine.add(newgame);
		bodyFirsLine.add(Box.createRigidArea(new Dimension(50, 0)));
		bodyFirsLine.add(loadgame);
		bodyFirsLine.setBackground(new java.awt.Color(25,35,125));
		body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
		bodyFirsLine.setSize(400,180);
		
		body.add(Box.createRigidArea(new Dimension(0, 10)));
		body.add(bodyFirsLine);
		JPanel bodySecondLine = new JPanel();
		bodySecondLine.setBackground(new java.awt.Color(25,35,125));
		bodySecondLine.setSize(400,180);
		
		exit.setFont(new Font("Arial",Font.PLAIN,20));
		exit.setForeground(java.awt.Color.RED);
		exit.setSize(100,50);
		bodySecondLine.add(exit);
		
		newgame.addActionListener(newgameListener);
		exit.addActionListener(exitListener);
				
		body.add(bodySecondLine);
		body.setSize(400,360);
		panel.add(body);
		container.add(panel);
		this.add(container);
		this.setLocation(450,0);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException{
		
		//logfajl
		File logFile=new File("log.txt");
	    log = new PrintWriter(new FileWriter(logFile));
	    
	    //ablak letrehozasa
	    app = new Application();
	    
		log.close();
	}
	
	//jatek vege
	public static void endGame(String winOrLose){
		System.out.println(winOrLose);
		log.println(winOrLose);
		System.out.println("Game Over!");
		log.close();
		
		System.exit(0);
	}
	//teljes statuszkepet ad a jatekrol
	//STATUSZ parancs
	public static void fullStatusz(){
		maze.listStatusz();
		if(replicator != null)
			System.out.println(general+"\n"+jaffa+"\n"+replicator);
		else{
			System.out.println(general+"\n"+jaffa+"\n"+"REPLICATOR:NULL");

		}
	}
}


