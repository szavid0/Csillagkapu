
public class Field extends AbstractBlock {
	
	protected boolean containsZpm = false;
	protected boolean containsBox = false;
	protected Box box;
	
	public Field(int id,int[] neighbours){
		super(id,neighbours);
		 passable=true;
	}
	public Field(int id,int[] neighbours,boolean hasBox,boolean hasZpm){
		super(id,neighbours);
		if(hasBox){
			this.containsBox = true;
			passable = false;
			box = new Box();
		}
		else{
			passable = true;
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
	@Override
	public Box getBox(){
		System.out.println("Field.getBox()");
		return this.box;
	}
	@Override
	public void setBox(Box box){
		System.out.println("Field.setBox(box)");
		this.box = box;
	}
	@Override
	public boolean isPassable(){
		System.out.println("Field.isPassable()");
		return passable;
	}
	@Override
	public void moveToThisBlock() {
		System.out.println("Field.moveToThisBlock()");
		if (containsBox == false){
			Application.general.setPosBlock(this);
			if(containsZpm == true){
				Application.general.collectZpm();
				containsZpm = false;
			}
		}
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
