//A LabirinthManager osztaly megvalositasa.
import java.util.List;
import java.util.ArrayList;

public class LabirinthManager {
	//Letaroljuk a palyat, a csillagkapukat es a kezdopoziciot.
	private List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean blueyellowWormHoleExists = false;
	private boolean redgreenWormHoleExists = false;
	private StarGate yellowStarGate;
	private StarGate blueStarGate;
	private StarGate greenStarGate;
	private StarGate redStarGate;
	public StarGate getRedStarGate() {
		return redStarGate;
	}

	private Field startField;

	//A konstruktorban a parameterkent atadott tesztesethez szukseges palyat hozzuk letre.
	public LabirinthManager(int teszteset){
		//Ezredes letrehozasa.
		Application.general= new General();
		
		//Tesztesetek es hozzajuk tartozo palyak.
		switch(teszteset){
		case 1: init1();break;
		case 2: init1();break;
		case 3: init3();break;
		case 4: init4();break;
		case 5: init5();break;
		case 6: init6();break;
		case 7: init7();break;
		case 8: init7();break;
		case 9: init9();break;
		case 10: init10();break;
		case 11: init11();break;
		case 12: init12();break;
		case 13: init13();break;
		case 14: init14();break;
		default:return;
		}
		
		//Az ezredest a kezdopozicioba rakjuk.
		Application.general.setPosBlock(startField);

	}
	
	//Ajto-merlegkezdomezo-mezo palya letrehozasa.
	private void init14() {
		
	}
	
	//Ajto-merleg-kezdomezo palya letrehozasa.
	private void init13() {

	}

	//Specialis fal-mezo-kezdomezo-sarga csillagkapu palya letrehozasa.
	private void init12() {
		
	}
	
	//Kek csillagkapu-mezo-kezdomezo palya letrehozasa.
	private void init11() {
		
	}
	
	//Specialis fal-mezo-kezdomezo palya letrehozasa.
	private void init10() {
		

	}
	
	//Sarga csillagkapu-kezdomezo-mezo-kek csillagkapu palya letrehozasa.
	private void init9() {
		
	}
	
	//Mezo-kezdomezo, ezredesnel van egy doboz palya letrehozasa.
	private void init7() {
		
	}
	
	//Kezdomezo-dobozos mezo palya letrehozasa.
	private void init6() {
		
	}
	
	//Ajto-merleg-kezdomezo palya letrehozasa.
	private void init5() {
		
	}
	
	//Ajto-dobozos merleg-kezdomezo  palya letrehozasa.
	private void init4() {
		
	}
	
	//Zpm-es mezo-kezdomezo palya letrehozasa.
	private void init3() {
	
	}
	
	//Szakadek-kezdomezo, ezredesnel doboz palya letrehozasa.
	private void init1() {
		
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
			greenStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.YELLOW);
			map.set(w.getIndex(), greenStarGate);
			
			//Ha van mar masik szinu csillagkapu, akkor feregjaratot csinalunk.
			if(redStarGate!= null)createWormHole(col);

		}else{
			redStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.YELLOW);
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
		else{
			map.set(yellowStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
			yellowStarGate=null;
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
}