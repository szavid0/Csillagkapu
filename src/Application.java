import java.io.*;
class Application {
	
	//azért staticok, mert csak egy létezik belőlük.
	public static General general = new General();
	public static Replicator replicator = new Replicator();
	public static Jaffa jaffa = new Jaffa();
	
	public static LabirinthManager maze;	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------");
		System.out.println("|   			SZKELETON MENU		    	|");
		System.out.println("---------------------------------------------------------");
		System.out.println("|	1.Szakadekba eses es game over			|");
		System.out.println("|	2.Doboz lerakasa szakadekba			|");
		System.out.println("|	3.ZPM felvetel es jatek megnyerese		|");
		System.out.println("|	4.Doboz felvetele merlegrol			|");
		System.out.println("|	5.Doboz lerakasa merlegre			|");
		System.out.println("|	6.Doboz felvetele mezorol			|");
		System.out.println("|	7.Doboz lerakasa mezore				|");
		System.out.println("|	8.Lepes mezore					|");
		System.out.println("|	9.Fereglyukba lepes				|");
		System.out.println("|	10.Loves specialis falra			|");
		System.out.println("|	11.Loves csillagkapura				|");
		System.out.println("|	12.Loves specialis falra(van csillagkapu)	|");
		System.out.println("|	13.Merlegre lepes				|");
		System.out.println("|	14.Merlegrol lelepes				|");
		System.out.println("|	15. Kilepes					|");
		System.out.println("---------------------------------------------------------");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		i = Integer.parseInt(in.readLine());
			general = new General();
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
		}
	}
	public static void endGame(String winOrLose){
		System.out.println("Application.endGame(" + winOrLose + ")");
	}
}
