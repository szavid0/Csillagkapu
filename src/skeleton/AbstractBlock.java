//AbstractBlock osztály megvalósítása.
//Alap építőelem, ebből származik a Field, Wall, Canyon és Door osztály.
//Nem lehet példányosítani.
public abstract class AbstractBlock {
	
	//Az elem indexének, szomszédjainak és áthaladhatóságának tárolása.
	protected int index;
	protected int[] neighbourIndexes = new int[4];
	protected boolean passable;
	
	//Az AbstractBlock konstruktorai.
	public AbstractBlock(){}
	public AbstractBlock(int[] neighbours){
		//Beállítjuk a blokk szomszédjainak indexét.
		this.neighbourIndexes=neighbours;
	}
	
	//Visszaadja az adott irányú szomszédját.
	public AbstractBlock getNeighbour(Direction dir){
			AbstractBlock neighbour = null;
			switch(dir){
			case NORTH: neighbour= Application.maze.getBlock(neighbourIndexes[0]);
			case SOUTH: neighbour= Application.maze.getBlock(neighbourIndexes[1]);
			case EAST: neighbour= Application.maze.getBlock(neighbourIndexes[2]);
			case WEST: neighbour= Application.maze.getBlock(neighbourIndexes[3]);	
			}
			System.out.println("AbstractBlock.getNegihbour("+dir+")");
			return neighbour;
	}
	
	//Visszaadja az adott blokk indexét.
	public int getIndex(){
		System.out.println("AbstractBlock.getIndex()");
		return index;
	}
	
	//Visszaadja, hogy át lehet-e rajta jutni. Lövedék vagy ezredes.
	public boolean isPassable(){
		System.out.println("AbstractBlock.isPassable()");
		return passable;
	}
	
	//Beállítjuk, az áthaladhatóságát.
	public void setPassable(boolean tf){
		System.out.println("AbstractBlock.setPassable("+tf+")");
		passable = tf;
	}
	
	//Abstract függvények:
	public abstract void moveToThisBlock();
	public abstract void shootOnThisBlock(Color col,Direction dir);
	public abstract void notifyBlock(); //notify() név esetén hibát dob a fordító.
	public abstract Box getBox();
}
