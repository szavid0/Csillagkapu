
public class Canyon extends AbstractBlock {

	@Override
	public void moveToThisBlock() {
		Application.general.setPosBlock(this);
		Application.general.die();
		Field start = Application.maze.getStartField();
		Application.general.setPosBlock(start);
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
