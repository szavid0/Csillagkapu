//A LabirinthManager osztaly megvalositasa.
import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;

import sun.security.action.GetBooleanAction;

public class LabirinthManager {
	//Letaroljuk a palyat, a csillagkapukat es a kezdopoziciot.
	private static List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean blueyellowWormHoleExists = false;
	private boolean redgreenWormHoleExists = false;
	static StarGate yellowStarGate;
	static StarGate blueStarGate;
	static StarGate greenStarGate;
	static StarGate redStarGate;
	private Field startField;
	private static int allZpmCnt;
	private static int JaffaZpmCnt = 0;
	private static int GeneralZpmCnt = 0;



	//A konstruktorban a parameterkent atadott tesztesethez szukseges palyat hozzuk letre.
	public LabirinthManager(){
		//Ezredes letrehozasa.
		
	}
	
	
	//Csillagkapu lekerese..
	public void setStarGate(StarGate s){
		if(s.getColor()==Color.BLUE)blueStarGate = s;
		else yellowStarGate = s;
	}
	
	//Irany megadasa.
	public Direction oppDir(Direction dir){
		if(dir == Direction.EAST)
			dir = Direction.WEST;
		else if(dir == Direction.WEST)
			dir = Direction.EAST;
		else if(dir == Direction.NORTH)
			dir = Direction.SOUTH;
		else
			dir = Direction.NORTH;

		return dir;
	}

	//Block lekerese.
	public AbstractBlock getBlock(int i){
		return map.get(i);
	}
	
	//Csillagkapu letrehozasa.
	public void createStarGate(Wall w,Color col,Direction dir){
		System.out.println("CREATESTARGATE "+col);
		Application.log.println("CREATESTARGATE "+col);

		
		//Ha kek volt a lovedek, akkor kek csillagkapu.
		if(col == Color.BLUE){
			blueStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.BLUE);
			map.set(w.getIndex(), blueStarGate);
			
			//Ha van mar masik szinu csillagkapu, akkor feregjaratot csinalunk.
			if(yellowStarGate!= null)createWormHole(col);
		}
		
		//Egyebkent sarga csillagkapu.
		else if (col == Color.YELLOW){
			yellowStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.YELLOW);
			map.set(w.getIndex(), yellowStarGate);
			
			//Ha van mar masik szinu csillagkapu, akkor feregjaratot csinalunk.
			if(blueStarGate!= null)createWormHole(col);

		}
		else if (col == Color.GREEN){
			greenStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.GREEN);
			map.set(w.getIndex(), greenStarGate);
			
			//Ha van mar masik szinu csillagkapu, akkor feregjaratot csinalunk.
			if(redStarGate!= null)createWormHole(col);

		}else{
			redStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.RED);
			map.set(w.getIndex(), redStarGate);
			
			//Ha van mar masik szinu csillagkapu, akkor feregjaratot csinalunk.
			if(greenStarGate!= null)createWormHole(col);

		}

	}
	
	//Csillagkapu torlese.
	public void deleteStarGate(Color col){
		System.out.println("DELETESTARGATE "+col);
		Application.log.println("DELETESTARGATE "+col);

		
		//Kitoroljuk az adott szinu csillagkaput es letrehozunk helyette egy specialis falat.
		if(col == Color.BLUE){
			map.set(blueStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
			blueStarGate=null;
			if(blueyellowWormHoleExists){
				map.set(yellowStarGate.getIndex(), new Wall(yellowStarGate.getIndex(),yellowStarGate.getNeighboursIndex(),true));
				yellowStarGate=null;
				System.out.println("DELETESTARGATE "+Color.YELLOW);
				Application.log.println("DELETESTARGATE "+Color.YELLOW);
			}
		}
		//Kitoroljuk az adott szinu csillagkaput es letrehozunk helyette egy specialis falat.
		else if(col == Color.YELLOW){
			map.set(yellowStarGate.getIndex(), new Wall(yellowStarGate.getIndex(),yellowStarGate.getNeighboursIndex(),true));
			yellowStarGate=null;
			if(blueyellowWormHoleExists){
				map.set(blueStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
				blueStarGate=null;
				System.out.println("DELETESTARGATE "+Color.BLUE);
				Application.log.println("DELETESTARGATE "+Color.BLUE);
			}
		}else if(col == Color.GREEN){
			map.set(greenStarGate.getIndex(), new Wall(greenStarGate.getIndex(),greenStarGate.getNeighboursIndex(),true));
			greenStarGate=null;
			if(redgreenWormHoleExists){
				map.set(redStarGate.getIndex(), new Wall(redStarGate.getIndex(),redStarGate.getNeighboursIndex(),true));
				redStarGate=null;
				System.out.println("DELETESTARGATE "+Color.RED);
				Application.log.println("DELETESTARGATE "+Color.RED);
			}
		}else{
			map.set(redStarGate.getIndex(), new Wall(redStarGate.getIndex(),redStarGate.getNeighboursIndex(),true));
			redStarGate=null;
			if(redgreenWormHoleExists){
				map.set(greenStarGate.getIndex(), new Wall(greenStarGate.getIndex(),greenStarGate.getNeighboursIndex(),true));
				greenStarGate=null;
				System.out.println("DELETESTARGATE "+Color.GREEN);
				Application.log.println("DELETESTARGATE "+Color.GREEN);
			}
		}
	}
	
	//Sagra csillagkapu lekerese.
	public StarGate getYellowStarGate(){
		return yellowStarGate;
	}
	
	//Kek csillagkapu lekerese.
	public StarGate getBlueStarGate(){
		return blueStarGate;
	}
	
	//Kezdo pozicio lekerese.
	public Field getStartField() {
		return (Field)map.get(54);
	}
	
	//Feregjarat letrehozasa.
	public void createWormHole(Color col1){
		System.out.println("CREATEWORMHOLE");
		Application.log.println("CREATEWORMHOLE");

		
		if(col1 == Color.YELLOW || col1 == Color.BLUE){
			blueyellowWormHoleExists = true;
			yellowStarGate.setPair(blueStarGate.getIndex(),oppDir(blueStarGate.getDirection()));
			blueStarGate.setPair(yellowStarGate.getIndex(),oppDir(yellowStarGate.getDirection()));
		}
		else{
			redgreenWormHoleExists = true;
			greenStarGate.setPair(redStarGate.getIndex(),oppDir(blueStarGate.getDirection()));
			redStarGate.setPair(greenStarGate.getIndex(),oppDir(yellowStarGate.getDirection()));
		}
		//Csillagkapu parok beallitasa.
		
	}

	public void transformCanyon(int index) {
		System.out.println("TRANSFORM CANYON");
		Application.log.println("TRANSFORM CANYON");

		
		int[] n = map.get(index).getNeighbours();
		map.set(index,new Field(index, n));
	}

	public StarGate getGreenStarGate() {
		return greenStarGate;
	}
	public StarGate getRedStarGate() {
		return redStarGate;
	}

	public static  void addZpm(Character character) {
		if (character == Application.general){
			GeneralZpmCnt++;
			System.out.println("COLLECTZPM ZPMCNT="+GeneralZpmCnt);
			Application.log.println("COLLECTZPM ZPMCNT="+GeneralZpmCnt);
			if(GeneralZpmCnt % 2 == 0){
				CreateZpm();
			}
			
			
		}else{
			JaffaZpmCnt++;
			System.out.println("COLLECTZPM ZPMCNT="+JaffaZpmCnt);
			Application.log.println("COLLECTZPM ZPMCNT="+JaffaZpmCnt);
		}
		
		if(JaffaZpmCnt + GeneralZpmCnt == allZpmCnt){
			Application.endGame(GeneralZpmCnt > JaffaZpmCnt ? "GENERAL WINS" : "JAFFA WINS");
		}
	}


	private static  void CreateZpm() {  //RANDOM
		System.out.println("CREATEZPM");
		Application.log.println("CREATEZPM");
	}
	private  void CreateZpm(int fieldIndex) {  //DETERMINISZTIKUS
		Field f = (Field)map.get(fieldIndex);
		f.setZpm();
		allZpmCnt++;
		System.out.println("PUTZPM "+fieldIndex);
		Application.log.println("PUTZPM "+fieldIndex);

	}
	
	public void addBlock(AbstractBlock a){
			map.add(a);
	}
}