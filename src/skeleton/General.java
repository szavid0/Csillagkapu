import java.util.ArrayList;

public class General {
	private AbstractBlock PosBlock;
	private Direction direction;
	private int lives = 3;
	private int ZPMCnt = 0;
	private int allZPMCnt;
	private ArrayList<Box> boxes;
	
	//A General konstruktora
	//3 az alapbeállított életek száma, beállítja, hogy nincs nála ZPM
	//sem pedig doboz.
	public General(){
		boxes = new ArrayList<Box>();
	}
	public General(ArrayList<Box> boxes){
		this.boxes = new ArrayList<Box>(boxes);
	}
	//visszaadja az ezredes pozicióját
	public AbstractBlock getPosBlock(){ 
		System.out.println("General.getPosBlock()");
		return PosBlock;
	}
	
	//a kapott irányba állítja az ezredes irányát
	public void setDirection(Direction dir){
		System.out.println("General.setDirection("+ dir +")");
		this.direction = dir;
	}
	
	//visszaadja az ezredes irányát
	public Direction getDirection(){
		System.out.println("General.getDirection()");
		return direction;
	}
	
	//beállítja az ezredes pozicióját a kapott blokkra
	public void setPosBlock(AbstractBlock block){
		System.out.println("General.setPosBlock(block)");
		PosBlock = block;
	}
	
	//Ha meghívják, akkor az ezredes ZPM számlálója megnő eggyel
	//(az osztálydiagrammal ellentétben nem kell megkapja magát a modult)
	public void collectZpm(){ 
		System.out.println("General.collectZPM()");		
		ZPMCnt++;
		
		//itt megnézzük, hogy felszedtük-e az összes ZPM-et
		//ha igen, akkor jelezzük az Applicationnek, hogy nyertünk.
		if(ZPMCnt == allZPMCnt)
			Application.endGame("WIN!");
	}
	
	//ha meghívják, akkor meghal az ezredes. 
	public void die(){
		//megnézi, hogy van e még veszthető élete, ha nincs jelezzük, hogy vesztett a játékos.
		if(lives ==	0)
			Application.endGame("LOSE!");
		else
			lives--;
		System.out.println("General.die()");

	}
	
	//visszaadja, hogy van-e az ezredesnél még dobboz
	public boolean hasBox(){
		System.out.println("General.hasBox()");
		return !boxes.isEmpty();
	}
	
	//visszaadja az utoljára felvett dobozt
	public Box getBox(){
		System.out.println("General.getBox()");
		return boxes.get(boxes.size() - 1);
	}
	
	//az ezredest ellépteti az adott irányba, ha lehet
	public void move(Direction dir){
		System.out.println("General.move("+ dir +")");
		direction = dir;
			AbstractBlock block = PosBlock.getNeighbour(dir);
			if(block.isPassable()){
				PosBlock.notifyBlock();
				block.moveToThisBlock();
		}
	}
	//felveszi a dobozt, ha van előtte
	public void pick(){
		System.out.println("General.pick()");
		AbstractBlock b = PosBlock.getNeighbour(direction);
		//leellenőrizzük, hogy visszaad-e dobozt. Ha igen akkor catolhatunk
		//különben elszállna a program
		if(b.getBox() != null){
				boxes.add(b.getBox());
			}	
	}
	//lerakja maga elé a dobozt, ha letudja
	public void drop(){
		System.out.println("General.drop()");

		if(PosBlock.getNeighbour(direction).isPassable()){
			AbstractBlock f = PosBlock.getNeighbour(direction);
			//megnézzük, hogy van-e rajta doboz 
				if(hasBox())f.setBox(getBox());
		}
	}
	
	//kapott színűt l�
	public void shoot(Color col){
		System.out.println("General.shoot("+col+")");
		
		AbstractBlock bulletPos;
		
		for( bulletPos = PosBlock.getNeighbour(direction); bulletPos.isPassable(); bulletPos = bulletPos.getNeighbour(direction)){
			//elmegy a lövedék ameddig nem ütközik valamibe.
		}
		//a blokk, amibe megakadt a lövedék lekezeli, hogy rálőttek 
		bulletPos.shootOnThisBlock(col, direction);
	}
	public void setallZpmCnt(int i) {
		this.allZPMCnt=i;
	}
}