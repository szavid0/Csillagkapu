
public class Wall extends AbstractBlock {

	private boolean isSpecial;
	
	public Wall(boolean isSpecial, int index){
		this.isSpecial=isSpecial;
		this.index = index;
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
}
