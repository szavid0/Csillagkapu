
public class Canyon extends AbstractBlock {

	@Override
	public void moveToThisBlock() {
		maze.getGeneral().setPosBlock(this);
		maze.getGeneral().die();
		Field start = maze.getStartField();
		maze.getGeneral().setPosBlock(start);
		System.out.println("Canyon.moveToThisBlock()");
	}
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		System.out.println("Canyon.shootOnThisBlock("+col+","+dir+")");
	}
	@Override
	public void notifyBlock() {
		System.out.println("Canyon.notifyBlock()");
	}
}
