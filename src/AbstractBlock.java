//AbstractBlock osztaly megvalositasa.
//Alap epitoelem, ebbol szarmazik a Field, Wall, Canyon es Door osztaly.
//Nem lehet peldanyositani.
public abstract class AbstractBlock {
	//Az elem indexenek, szomszedjainak es athaladhatosaganak tarolasa.
	protected int index;
	protected int[] neighbourIndexes = new int[4];
	protected boolean passable =true;
	protected boolean shootable = true;
	public boolean isShootable() {
		return shootable;
	}
	public void setShootable(boolean shootable) {
		this.shootable = shootable;
	}
	//Az AbstractBlock konstruktorai.
	public AbstractBlock(){}
	public AbstractBlock(int id,int[] neighbours){
		this.index = id;
		this.neighbourIndexes=neighbours;
	}
	
	//Visszaadja az adott iranyu szomszedjat.
	public AbstractBlock getNeighbour(Direction dir){
			AbstractBlock neighbour = null;
			switch(dir){
			case NORTH: neighbour= Application.maze.getBlock(neighbourIndexes[0]);break;
			case SOUTH: neighbour= Application.maze.getBlock(neighbourIndexes[1]);break;
			case EAST: neighbour= Application.maze.getBlock(neighbourIndexes[2]);break;
			case WEST: neighbour= Application.maze.getBlock(neighbourIndexes[3]);break;
			}
			return neighbour;
	}
	
	//Visszaadja az adott blokk indexet.
	public int getIndex(){
		return index;
	}
	
	//Visszaadja, hogy at lehet-e rajta jutni. Lovedek vagy ezredes.
	public boolean isPassable(){
		if(!passable)
			System.out.println("NEIGHBOUR NOT PASSABLE");
		return passable;
	}
	
	//Beallitjuk, az athaladhatosagat.
	public void setPassable(boolean tf){
		passable = tf;
	}
	
	//Abstract fuggvenyek:
	public abstract void moveToThisBlock(Character creature);
	public abstract void moveToThisBlock(Replicator creature);

	public abstract void shootOnThisBlock(Color col,Direction dir);
	//notify() nev eseten hibat dob a fordito.
	public abstract void notifyBlock();
	
	public boolean getContainsBox(){
		System.out.println("NO BOX ON NEIGHBOUR");
		return false;
	}
	public Box getBox(){
		return null;
	}
	public void setBox(Box box){
	}
	public int[] getNeighbours() {
		return neighbourIndexes;
	}

}