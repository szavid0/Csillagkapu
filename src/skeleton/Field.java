
public class Field extends AbstractBlock {
	
	protected boolean containsZpm;
	protected boolean containsBox;
	protected Zpm modul;
	protected Box box;
	
	public boolean getContainsBox(){
		System.out.println("Field.getContainsBox()");
		return containsBox;
	}
	public boolean getContainsZpm(){
		System.out.println("Field.getContainsZpm()");
		return containsZpm;
	}
	public Box getBox(){
		System.out.println("Field.getBox()");
		return this.box;
	}
	public void setBox(Box box){
		System.out.println("Field.setBox("+box.getClass()+")");
		this.box = box;
	}
	@Override
	public void moveToThisBlock() {
		if (containsBox == false){
			Application.general.setPosBlock(this);
			if(containsZpm == true){
				Application.general.collectZpm();
				containsZpm = false;
			}
		}
		System.out.println("Field.moveToThisBlock()");
	}
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		System.out.println(this.getClass()+" shootOnThisBlock("+col+","+dir+")");
	}

	@Override
	public void notifyBlock() {
		System.out.println("Field.notifyBlock()");
	}
}
