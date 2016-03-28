
public class Field extends AbstractBlock {
	
	protected boolean containsZpm = false;
	protected boolean containsBox = false;
	protected Box box;
	
	public Field(int id,int[] neighbours){
		super(id,neighbours);
	}
	public Field(int id,int[] neighbours,boolean hasBox,boolean hasZpm){
		super(id,neighbours);
		if(hasBox){
			this.containsBox = true;
			box = new Box();
		}
		if(hasZpm){
			this.containsZpm = true;
		}
	}
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
