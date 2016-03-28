
public abstract class AbstractBlock {
	
	protected int index;
	protected int[] neighbourIndexes = new int[4];
	protected boolean passable;
	
	//Az AbstractBlock konstruktorai
	public AbstractBlock(){}
	public AbstractBlock(int id,int[] neighbours){
		this.index = id;
		this.neighbourIndexes=neighbours;
	}
	
	//visszaadja az adott irányú szomszédját
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
	
	//visszaadja az adott blokk indexét
	public int getIndex(){
		System.out.println("AbstractBlock.getIndex()");
		return index;
	}
	
	//visszaadja, hogy át lehet-e rajta jutni. Lövedék vagy ezredes
	public boolean isPassable(){
		System.out.println("AbstractBlock.isPassable()");
		return passable;
	}
	
	//beállítjuk, az áthaladhatóságát
	public void setPassable(boolean tf){
		System.out.println("AbstractBlock.setPassable("+tf+")");
		passable = tf;
	}
	
	//Abstract függvények:
	public abstract void moveToThisBlock();
	public abstract void shootOnThisBlock(Color col,Direction dir);
	public abstract void notifyBlock(); //notify() n�v eset�n hib�t dob a ford�t�
	public abstract Box getBox();
}
