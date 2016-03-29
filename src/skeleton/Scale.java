
public class Scale extends Field {
	private Door doorToOpen;
	
	public Scale(int id,int[] n){
		super(id,n);
		passable=true;
	}
	public Scale(int id,int[] n,Door d,boolean hasBox,boolean hasZpm){
		super(id,n,hasBox,hasZpm);
		this.doorToOpen=d;
		if(hasBox){
			passable=false;
			box = new Box();
		}
	}
	@Override
	public void moveToThisBlock(){
		System.out.println("Scale.moveToThisBlock()");
		if(containsBox == false){
			Application.general.setPosBlock(this);
			doorToOpen.Open(true);
			if(containsZpm == true){
				Application.general.collectZpm();
				containsZpm = false;
			}
		}
	}
	@Override
	public void setBox(Box box){
		System.out.println("Scale.setBox(box)");
		this.box=box;
		doorToOpen.Open(true);
	}
	@Override
	public Box getBox(){
		System.out.println("Scale.getBox()");
		doorToOpen.Open(false);
		return box;
	}
	@Override
	public void notifyBlock(){
		System.out.println("Scale.notifyBlock()");
		doorToOpen.Open(false);
	}
}
