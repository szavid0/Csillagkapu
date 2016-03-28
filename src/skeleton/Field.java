//Mező osztály megvalósítása, AbstractBlockból öröklődik.
public class Field extends AbstractBlock {
	
	//Letároljuk, tartalmaz-e ZPM modult vagy dobozt.
	protected boolean containsZpm;
	protected boolean containsBox;
	protected Zpm modul;
	protected Box box;
	
	//Visszaadja van-e rajta doboz.
	public boolean getContainsBox(){
		System.out.println("Field.getContainsBox()");
		return containsBox;
	}
	
	//Visszaadja van-e rajta ZPM modul.
	public boolean getContainsZpm(){
		System.out.println("Field.getContainsZpm()");
		return containsZpm;
	}
	
	//Visszaadja a rajta tárolt dobozt.
	public Box getBox(){
		System.out.println("Field.getBox()");
		return this.box;
	}
	
	//Rárak egy dobozt a mezőre.
	public void setBox(Box box){
		System.out.println("Field.setBox("+box.getClass()+")");
		this.box = box;
	}
	
	//Az ezredes rálép, ha nincs rajta doboz és összegyűjti a ZPM-et, ha van rajta.
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
	
	//Lövésnél megadja a lövedék helyzetét, irányát, színét.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		System.out.println(this.getClass()+" shootOnThisBlock("+col+","+dir+")");
	}
	
	//Mezőről lelépés esemény értesítésére.
	@Override
	public void notifyBlock() {
		System.out.println("Field.notifyBlock()");
	}
}
