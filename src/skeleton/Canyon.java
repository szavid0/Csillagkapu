//A szakadék osztályt valósítja meg, az AbstractBlock-ból öröklődik.
class Canyon extends AbstractBlock {
	
	//Ha szakadékba lépünk, akkor az ezredes életet veszít.
	//Ha nincs vége a játéknak, akkor beállítja az ezredest a start-pozícióba.
	@Override
	public void moveToThisBlock() {
		Application.general.setPosBlock(this);
		Application.general.die();
		Field start = Application.maze.getStartField();
		Application.general.setPosBlock(start);
		System.out.println("Canyon.moveToThisBlock()");
	}
	
	//Erre a blokkra nem tudunk rálőni, így nem csinál a függvény semmit, ha meghívják
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		System.out.println("Canyon.shootOnThisBlock("+col+","+dir+")");
	}
	
	//Nem szükséges a jelzés neki, így nem csinál semmit.
	@Override
	public void notifyBlock() {
		System.out.println("Canyon.notifyBlock()");
	}
	
	//Null értéket ad vissza, hisz nem lehet rajta doboz.
	@Override
	public Box getBox() {
		System.out.println("Canyon.getBox()");
		return null;
	}
	
}
