
public class Wall extends AbstractBlock {

	private boolean isSpecial;
	
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
	@Override
	public void moveToThisBlock() {
		System.out.println("Wall.moveToThisBlock()");
	}
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		if (isSpecial){
			Application.maze.createStarGate(this, col, dir);
		}
		System.out.println("Wall.shootOnThisBlock("+col+","+dir+")");
	}
	@Override
	public void notifyBlock() {
		System.out.println("Wall.notifyBlock()");
	}
	@Override
	public Box getBox() {
		return null;
	}
}
