
public class Scale extends Field {
	private Door doorToOpen;
	
	public Scale(Door d){
		this.doorToOpen=d;
	}
	@Override
	public void moveToThisBlock(){
		if(containsBox == false){
			Application.general.setPosBlock(this);
			doorToOpen.Open(true);
			if(containsZpm == true){
				Application.general.collectZpm(modul);
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
