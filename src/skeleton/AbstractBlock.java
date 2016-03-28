
public abstract class AbstractBlock {
	
	protected int index;
	protected int[] neighbourIndexes = new int[4];
	protected boolean passable;
	
	public AbstractBlock(){}
	public AbstractBlock(int[] neighbours){
		this.neighbourIndexes=neighbours;
	}
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
	public int getIndex(){
		System.out.println("AbstractBlock.getIndex()");
		return index;
	}
	public boolean isPassable(){
		System.out.println("AbstractBlock.isPassable()");
		return passable;
	}
	public void setPassable(boolean tf){
		System.out.println("AbstractBlock.setPassable("+tf+")");
		passable = tf;
	}
	public abstract void moveToThisBlock();
	public abstract void shootOnThisBlock(Color col,Direction dir);
	public abstract void notifyBlock(); //notify() n�v eset�n hib�t dob a ford�t�
}
