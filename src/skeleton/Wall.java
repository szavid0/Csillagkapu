//Fal osztály megvalósítása, AbstractBlockból öröklődik.
public class Wall extends AbstractBlock {
	//Speciális fal-e, melyre lőve csillagkapu alakul ki.
	private boolean isSpecial;
	
	//Konstruktor, beállítja az isSpecial és az index értékét.
	public Wall(int id,int[] n){
		super(id,n);
	}
	public Wall(int id,int[] neighbours,boolean isSpecial){
		super(id,neighbours);
		this.isSpecial=isSpecial;
		this.index = index;
	}
	public int[] getNeighboursIndex(){
		return neighbourIndexes;
	}
	
	//Falra nem lehet lépni.
	@Override
	public void moveToThisBlock() {
		System.out.println("Wall.moveToThisBlock()");
	}
	
	//Speciális fal esetén rálövés kezelése.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		if (isSpecial){
			Application.maze.createStarGate(this, col, dir);
		}
		System.out.println("Wall.shootOnThisBlock("+col+","+dir+")");
	}
	
	//Nem szükséges a jelzés neki, így nem csinál semmit.
	@Override
	public void notifyBlock() {
		System.out.println("Wall.notifyBlock()");
	}
	
	//Null értéket ad vissza, hisz nem lehet rajta doboz.
	@Override
	public Box getBox() {
		return null;
	}
}
