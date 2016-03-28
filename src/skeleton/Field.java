//Mező osztály megvalósítása, AbstractBlockból öröklődik.
public class Field extends AbstractBlock {
	//Letároljuk, tartalmaz-e ZPM modult vagy dobozt.
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

	//Nem szükséges a jelzés neki, így nem csinál semmit.
	@Override
	public void notifyBlock() {
		System.out.println("Field.notifyBlock()");
	}
}
