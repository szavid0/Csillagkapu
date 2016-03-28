//Az ezredes osztályának megvalósítása.
//Az ezredest tudja irányítani a játékos a pályán.
import java.util.ArrayList;

public class General {
	//Tárolja az ezredes kezdő blockját, irányát, életeinek számát, nála lévő ZPM-ek, illetve a pályán lévő összes ZPM számát és a dobozokat.
	private AbstractBlock PosBlock;
	private Direction direction;
	private int lives;
	private int ZPMCnt;
	private int allZPMCnt;
	private ArrayList<Box> boxes;
	
	//A General konstruktora.
	//3 az alapbeállított életek száma, beállítja, hogy nincs nála ZPM, se doboz.
	public General(){
		System.out.println("General constructor");
		lives = 3;
		ZPMCnt = 0;
		boxes = new ArrayList<Box>();
	}
	public General(ArrayList<Box> boxes){
		this.boxes = boxes;
	}
	
	//Visszaadja az ezredes pozicióját.
	public AbstractBlock getPosBlock(){ 
		System.out.println("General.getPosBlock()");
		return PosBlock;
	}
	
	//A kapott irányba állítja az ezredes irányát.
	public void setDirection(Direction dir){
		System.out.println("General.setDirection("+ dir +")");
		this.direction = dir;
	}
	
	//Visszaadja az ezredes irányát.
	public Direction getDirection(){
		System.out.println("General.getDirection()");
		return direction;
	}
	
	//Beállítja az ezredes pozicióját a kapott blokkra.
	public void setPosBlock(AbstractBlock block){
		System.out.println("General.setPosBlock(block)");
		PosBlock = block;
	}
	
	//Ha meghívják, akkor az ezredes ZPM számlálója megnő eggyel.
	//(az osztálydiagrammal ellentétben nem kell megkapja magát a modult)
	public void collectZpm(){ 
		System.out.println("General.collectZPM()");
		
		ZPMCnt++;
		
		//Itt megnézzük, hogy felszedtük-e az összes ZPM-et.
		//Ha igen, akkor jelezzük az Applicationnek, hogy nyertünk.
		if(ZPMCnt == allZPMCnt)
			Application.endGame("WIN!");
	}
	
	//Ha meghívják, akkor meghal az ezredes. 
	public void die(){
		//Megnézi, hogy van e még veszthető élete, ha nincs jelezzük, hogy vesztett a játékos.
		if(lives ==	0)
			Application.endGame("LOSE!");
		else
			lives--;
		System.out.println("General.die()");

	}
	
	//Visszaadja, hogy van-e az ezredesnél még dobboz.
	public boolean hasBox(){
		System.out.println("General.hasBox()");
		return boxes.size() > 0;
	}
	
	//Visszaadja az utoljára felvett dobozt.
	public Box getBox(){
		System.out.println("General.getBox()");
		return boxes.get(boxes.size() - 1);
	}
	
	//Az ezredest ellépteti az adott irányba, ha lehet.
	public void move(Direction dir){
		System.out.println("General.move("+ dir +")");
		
		AbstractBlock block = PosBlock.getNeighbour(dir);
		
		//Ha rá lehet lépni, akkor beállítjuk a pozíciónak.
		//Az eddigi blokkot pedig értesítjük, hogy elléptünk róla.
		if(block.isPassable()){
			PosBlock.notifyBlock();
			block.moveToThisBlock();
		}
			
	}
	
	//Felveszi a dobozt, ha van előtte.
	public void pick(){
		System.out.println("General.pick()");
		
		
		AbstractBlock b = PosBlock.getNeighbour(direction);
		//Leellenőrizzük, hogy visszaad-e dobozt. Ha igen akkor felvesszük.
		if(b.getBox() != null){
			Field f = (Field)b;
			if(f.getContainsBox()){
				boxes.add(f.getBox());
			}
		}
	}
	
	//Lerakja maga elé a dobozt, ha letudja.
	public void drop(){
		System.out.println("General.drop()");
		
		if(PosBlock.getNeighbour(direction).isPassable()){
			Field f = (Field)PosBlock.getNeighbour(direction);
			//Megnézzük, hogy van-e rajta doboz.
			if(!f.getContainsBox()){
				if(hasBox())
					f.setBox(getBox());;
			}
		}
	}
	
	//Kapott színű lövedéket lő.
	public void shoot(Color col){
		System.out.println("General.shoot()");
		
		AbstractBlock bulletPos;
		
		for( bulletPos = PosBlock.getNeighbour(direction); bulletPos.isPassable(); bulletPos = bulletPos.getNeighbour(direction)){
			//Elmegy a lövedék, ameddig nem ütközik valamibe.
		}
		//A blokk, amibe megakadt a lövedék lekezeli, hogy rálőttek.
		bulletPos.shootOnThisBlock(col, direction);
	}
}