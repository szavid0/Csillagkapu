
public class Door extends AbstractBlock {
	public void Open(boolean tf){
		passable=tf;
	}
	@Override
	public void moveToThisBlock() {
		if(passable==true)	
			Application.general.setPosBlock(this);	
		System.out.println("Door.moveToThisBlock()");
	}
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {		
		System.out.println("Door.shootOnThisBlock("+col+","+dir+")");
	}
	@Override
	public void notifyBlock() {		
		System.out.println("Door.notifyBlock()");
	}
	@Override
	public Box getBox() {
		return null;
	}
}
