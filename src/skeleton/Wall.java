//Fal osztály megvalósítása, AbstractBlockból öröklődik
public class Wall extends AbstractBlock {
	//Speciális fal-e, melyre lőve csillagkapu alakul ki.
	private boolean isSpecial;
	
	//Konstruktor, beállítja az isSpecial és az index értékét.
	public Wall(boolean isSpecial, int index){
		this.isSpecial=isSpecial;
		this.index = index;
	}
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
	
	//notifyBlock() nem csinál semmit, mivel nem mérleg.
	@Override
	public void notifyBlock() {
		System.out.println("Wall.notifyBlock()");
	}
	
	//Falon nincsen doboz, tehát nem lehet felvenni.
	@Override
	public Box getBox() {
		return null;
	}
}
