//Ajtó osztály megvalósítása, AbstractBlock-ból öröklődik.
public class Door extends AbstractBlock {

	//Nyitás függvény, áthaladhatóság beállításra kerül.
    public void Open(boolean tf){
		passable=tf;
	}
    
    //Rálépés esemény, ha áthaladhatóság engedélyezve van, a pozíció erre az elemre változik.
	@Override
	public void moveToThisBlock() {
		if(passable==true)	
			Application.general.setPosBlock(this);	
		System.out.println("Door.moveToThisBlock()");
	}
    
    //Lövés kezelése az ajtónál.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {		
		System.out.println("Door.shootOnThisBlock("+col+","+dir+")");
	}
    
    //Nem szükséges a jelzés neki, így nem csinál semmit.
	@Override
	public void notifyBlock() {		
		System.out.println("Door.notifyBlock()");
	}
    
    //getBox() megvalósítása; de ajtón nem lehet doboz, tehát felvenni sem lehet.
	@Override
	public Box getBox() {
		return null;
	}
}
