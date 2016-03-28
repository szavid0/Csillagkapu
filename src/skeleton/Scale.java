//Mérleg osztály megvalósítása, a mezőből öröklődik.
public class Scale extends Field {

	//A mérleghez tartozó ajtó.
	private Door doorToOpen;
	
	//Konstruktor, doorToOpen-t állítja be.
	public Scale(Door d){
		this.doorToOpen=d;
	}
	
	//Az ezredes rálép, ha nincs rajta doboz és összegyűjti a ZPM-et, ha van rajta. Ajtót nyit.
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
	
	//Lelépés esemény értesítésére. Ajtót bezárja.
	@Override
	public void notifyBlock(){
		System.out.println("Scale.notifyBlock()");
		doorToOpen.Open(false);
	}
}
