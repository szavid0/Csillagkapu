
public class Scale extends Field {
	private Door doorToOpen;
	
	public Scale(int id,int[] n){
		super(id,n);
	}
	public Scale(int id,int[] n,Door d,boolean hasBox,boolean hasZpm){
		super(id,n,hasBox,hasZpm);
		this.doorToOpen=d;
	}
	@Override
	public void moveToThisBlock(){
		if(containsBox == false){
			Application.general.setPosBlock(this);
			doorToOpen.Open(true);
			if(containsZpm == true){
				Application.general.collectZpm();
				containsZpm = false;
			}
		}
		System.out.println("Scale.moveToThisBlock()");
	}
	@Override
	public void notifyBlock(){
		System.out.println("Scale.notifyBlock()");
		doorToOpen.Open(false);
	}
}
