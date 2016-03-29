import java.util.List;
import java.util.ArrayList;


public class LabirinthManager {
	private List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean WormHoleExists = false;
	private StarGate yellowStarGate;
	private StarGate blueStarGate;
	private Field startField;

	//a konstruktorban a paraméterként átadott tesztesethez szükséges pályát hozzuk létre
	public LabirinthManager(int teszteset){
		Application.general= new General();

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
		Application.general.setPosBlock(startField);

	}
	//ajtó-mérlegkezdőmező-mező pálya létrehozása
	private void init14() {
		int[] t = new int[4];
		t[2] = 1;
		Door d = new Door(0,t);
		map.add(d);
		t = new int[4];
		t[2]=2;
		t[3]=0;
		startField = new Scale(1,t,d,false,false);
		map.add(startField);
		t = new int[4];
		t[3] = 1;
		map.add(new Field(2,t));
	}
	//ajtó-mérleg-kezdőmező pálya létrehozása
	private void init13() {
		int[] t = new int[4];
		t[2] = 1;
		Door d = new Door(0,t);
		map.add(d);
		t = new int[4];
		t[2]=2;
		t[3]=0;
		map.add(new Scale(1,t,d,false,false));
		t = new int[4];
		t[3] = 1;
		startField = new Field(2,t);
		map.add(startField);
	}

	//speciális fal-mezõ-kezdõmezõ-sárga csillagkapu pálya létrehozása
	private void init12() {
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2]=1;
		map.add(new Wall(0,t,true));
		t = new int[4];
		t[3]=0;
		t[2]=2;
		map.add(new Field(1,t));
		t = new int[4];
		t[3]=1;
		t[2]=3;
		startField = new Field(2,t);
		map.add(startField);
		t = new int[4];
		t[3]=2;
		yellowStarGate = new StarGate(3,t,Direction.WEST,Color.YELLOW);
		map.add(yellowStarGate);
	}
	//kék csillagkapu-mezõ-kezdõmezõ pálya létrehozása
	private void init11() {
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2]=1;
		blueStarGate = new StarGate(0,t,Direction.EAST,Color.BLUE);
		map.add(blueStarGate);
		t = new int[4];
		t[3]=0;
		t[2]=2;
		map.add(new Field(1,t));
		t = new int[4];
		t[3]=1;
		startField = new Field(2,t);
		map.add(startField);
	}
	//speciális fal-mezõ-kezdõmezõ pálya létrehozása
	private void init10() {
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2]=1;
		map.add(new Wall(0,t,true));
		t = new int[4];
		t[3]=0;
		t[2]=1;
		map.add(new Field(1,t));
		t = new int[4];
		t[3]=1;
		startField = new Field(2,t);
		map.add(startField);

	}
	//sárga csillagkapu-kezdõmezõ-mezõ-kék csillagkapu pálya létrehozása
	private void init9() {
		int[] t = new int[4];
		t[2]=1;
		yellowStarGate = new StarGate(0,t,Direction.EAST,Color.YELLOW,true);
		map.add(yellowStarGate);
		t = new int[4];
		t[3]=0;
		t[2]=2;
		startField = new Field(1,t);
		map.add(startField);
		t = new int[4];
		t[3]=1;
		t[2]=3;
		map.add(new Field(2,t));
		t = new int[4];
		t[3] = 2;
		blueStarGate = new StarGate(3,t,Direction.WEST,Color.BLUE,true);
		map.add(blueStarGate);
		createWormHole();
	}
	//mezõ-kezdõmezõ, ezredesnél van egy doboz pálya létrehozása
	private void init7() {
		ArrayList<Box> b = new ArrayList<Box>();
		b.add(new Box());
		Application.general = new General(b);
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2] = 2;
		map.add(new Field(0,t));
		t = new int[4];
		t[3] = 0;
		startField = new Field(1,t);
		map.add(startField);
	}
	//kezdõmezõ-dobozos mezõ pálya létrehozása
	private void init6() {
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2] = 1;
		startField=new Field(0,t);
		map.add(startField);
		t=new int[4];
		t[3]=0;
		map.add(new Field(1,t,true,false));
	}
	//ajtó-mérleg-kezdõmezõ pálya létrehozása
	private void init5() {
		ArrayList<Box> b = new ArrayList<Box>();
		b.add(new Box());
		Application.general = new General(b);
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2] = 1;
		Door d = new Door(0,t);
		map.add(d);
		t = new int[4];
		t[2]=2;
		t[3]=0;
		Field scale = new Scale(1,t,d,false,false);
		map.add(scale);
		t = new int[4];
		t[3]=1;
		startField = new Field(2,t);
		map.add(startField);
	}
	//ajtó-dobozos mérleg-kezdõmezõ  pálya létrehozása
	private void init4() {
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[2] = 1;
		Door d = new Door(0,t);
		map.add(d);
		t = new int[4];
		t[2]=2;
		t[3]=0;
		map.add(new Scale(1,t,d,true,false));
		t = new int[4];
		t[3] = 1;
		startField = new Field(2,t);
		map.add(startField);
	}
	//zpm-es mezõ-kezdõmezõ pálya létrehozása
	private void init3() {
		ArrayList<Box> b = new ArrayList<Box>();
		b.add(new Box());
		Application.general = new General(b);
		Application.general.setallZpmCnt(1);
		Application.general.setDirection(Direction.WEST);
		int[] t = new int[4];
		t[3] = 1;
		map.add(new Field(0,t,false,true));
		t = new int[4];
		t[3] = 0;
		startField = new Field(1,t);
		map.add(startField);
	}
	//szakadék-kezdõmezõ, ezredesnél doboz pálya létrehozása
	private void init1() {
		ArrayList<Box> b = new ArrayList<Box>();
		b.add(new Box());
		Application.general = new General(b);
		int[] t = new int[4];
		t[2] = 1;
		map.add(new Canyon(0,t));
		t = new int[4];
		t[3] = 0;
		startField = new Field(1,t);
		map.add(startField);
	}
	public void setStarGate(StarGate s){
		if(s.getColor()==Color.BLUE)blueStarGate = s;
		else yellowStarGate = s;
	}
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

	public AbstractBlock getBlock(int i){
		System.out.println("LabirinthManager.getBlock()");
		return map.get(i);
	}
	public void createStarGate(Wall w,Color col,Direction dir){
		System.out.println("LabirinthMaganger.createStarGate(w,"+col+","+ dir+")");

		if(col == Color.BLUE){
			blueStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.BLUE);
			map.set(w.getIndex(), blueStarGate);
			if(yellowStarGate!= null)createWormHole();
		}
		else{
			yellowStarGate = new StarGate(w.getIndex(),w.getNeighboursIndex(),dir, Color.YELLOW);
			map.set(w.getIndex(), yellowStarGate);
			if(blueStarGate!= null)createWormHole();

		}

	}
	public void deleteStarGate(Color col){
		System.out.println("LabirinthMaganger.deleteStarGate("+col+")");
		if(col == Color.BLUE){
			map.set(blueStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
			blueStarGate=null;
		}
		else{
			map.set(yellowStarGate.getIndex(), new Wall(blueStarGate.getIndex(),blueStarGate.getNeighboursIndex(),true));
			yellowStarGate=null;
		}
	}
	public StarGate getYellowStarGate(){
		System.out.println("LabirinthMaganger.getYellowStarGate()");
		return yellowStarGate;
	}
	public StarGate getBlueStarGate(){
		System.out.println("LabirinthMaganger.getBlueStarGate()");
		return blueStarGate;
	}
	public Field getStartField() {
		System.out.println("LabirinthMaganger.getStartField()");
		return startField;
	}
	public void createWormHole(){
		System.out.println("LabirinthManager.CreateWormHole()");
		WormHoleExists = true;
		yellowStarGate.setPair(blueStarGate.getIndex(),oppDir(blueStarGate.getDirection()));
		blueStarGate.setPair(yellowStarGate.getIndex(),oppDir(yellowStarGate.getDirection()));
	}
}
