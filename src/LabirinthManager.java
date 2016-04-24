//A LabirinthManager osztaly megvalositasa.
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import sun.security.action.GetBooleanAction;

public class LabirinthManager {
	//Letaroljuk a palyat, a csillagkapukat es a kezdopoziciot.
	private static List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean blueyellowWormHoleExists = false;
	private boolean redgreenWormHoleExists = false;
	private StarGate yellowStarGate;
	private StarGate blueStarGate;
	private StarGate greenStarGate;
	private StarGate redStarGate;
	private Field startField;
	private static int allZpmCnt;
	private static int JaffaZpmCnt = 0;
	private static int GeneralZpmCnt = 0;



	//A konstruktorban a parameterkent atadott tesztesethez szukseges palyat hozzuk letre.
	public LabirinthManager(int teszteset){
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
		System.out.println("LabirinthManager.getBlock()");
		return map.get(i);
	}
	
	//Csillagkapu letrehozasa.
	public void createStarGate(Wall w,Color col,Direction dir){
		System.out.println("LabirinthMaganger.createStarGate(w,"+col+","+ dir+")");
		
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
		System.out.println("LabirinthMaganger.deleteStarGate("+col+")");
		
		//Kitoroljuk az adott szinu csillagkaput es letrehozunk helyette egy specialis falat.
		if(col == Color.BLUE){
			map.set(blueStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
			blueStarGate=null;
		}
		//Kitoroljuk az adott szinu csillagkaput es letrehozunk helyette egy specialis falat.
		else if(col == Color.YELLOW){
			map.set(yellowStarGate.getIndex(), new Wall(yellowStarGate.getIndex(),yellowStarGate.getNeighboursIndex(),true));
			yellowStarGate=null;
		}else if(col == Color.GREEN){
			map.set(greenStarGate.getIndex(), new Wall(greenStarGate.getIndex(),greenStarGate.getNeighboursIndex(),true));
			greenStarGate=null;
		}else{
			map.set(redStarGate.getIndex(), new Wall(redStarGate.getIndex(),redStarGate.getNeighboursIndex(),true));
			redStarGate=null;
		}
	}
	
	//Sagra csillagkapu lekerese.
	public StarGate getYellowStarGate(){
		System.out.println("LabirinthMaganger.getYellowStarGate()");
		return yellowStarGate;
	}
	
	//Kek csillagkapu lekerese.
	public StarGate getBlueStarGate(){
		System.out.println("LabirinthMaganger.getBlueStarGate()");
		return blueStarGate;
	}
	
	//Kezdo pozicio lekerese.
	public Field getStartField() {
		System.out.println("LabirinthMaganger.getStartField()");
		return startField;
	}
	
	//Feregjarat letrehozasa.
	public void createWormHole(Color col1){
		System.out.println("LabirinthManager.CreateWormHole()");
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
			if(GeneralZpmCnt % 2 == 0){
				CreateZpm();
			}
		}else{
			JaffaZpmCnt++;
		}
		
		if(JaffaZpmCnt + GeneralZpmCnt == allZpmCnt){
			Application.endGame(GeneralZpmCnt > JaffaZpmCnt ? "General Wins" : "Jaffa Wins");
		}
	}


	private static  void CreateZpm() {  //RANDOM
		//TODO
		
	}
	private  void CreateZpm(int fieldIndex) {  //DETERMINISZTIKUS
		Field f = (Field)map.get(fieldIndex);
		f.setZpm();
		allZpmCnt++;
	}
}