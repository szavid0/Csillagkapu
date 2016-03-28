//A csillagkapu osztály megvalósítása, a falból öröklődik.
public class StarGate extends Wall {
	//Irány, szín, van-e csillagkapu párja meghatározása.
	private Direction direction;
	private Color color;
	private boolean isPaired;
	
	//Csillagkapu irányának átkonvertálása integer-re.
	private int dirToInt(Direction dir){
		if(dir == Direction.EAST)
			return 0;
		else if(dir == Direction.WEST)
			return 2;
		else if(dir == Direction.NORTH)
			return 1;
		else 
			return 3;
	}
	
	//Konstruktor, beállítja az irányt, színt és indexet.
	public StarGate(Direction dir,Color col, int index){
		super(true, index);  //**speciális falként inicalizálódik
		this.direction=dir;
		this.color=col;
	}
	
	//Visszaadja, hogy van-e párja.
	public boolean getIsPaired(){
		System.out.println("StarGate.getIsPaired()");
		return isPaired;
	}
	
	//Visszaadja az irányát.
	public Direction getDirection(){
		System.out.println("StarGate.getDirection()");
		return direction;
	}
	
	//Visszaadja a színét.
	public Color getColor(){
		System.out.println("StarGate.getColor()");
		return color;
	}
	
	//Rálépés esemény kezelése.
	@Override
	public void moveToThisBlock(){
		if(isPaired){
			//Ha van párja, megkeressük.
			//Ha nincs, akkor nem csinálunk semmit.
			StarGate pair = null;
			if(color == Color.BLUE) {
				//Sárga pár.
				pair = Application.maze.getYellowStarGate();
			}
			else{
				//Kék pár.
				pair = Application.maze.getBlueStarGate();
			}
			//Lekéri a párjának az irányát és az ott lévő szomszédot.
			Direction dir = pair.getDirection();
			AbstractBlock neighbour = pair.getNeighbour(direction);	
			//Átlépünk arra a blockra és beállítjuk az ezredes irányát.
			Application.general.setPosBlock(neighbour);
			Application.general.setDirection(dir);
		}
		System.out.println("StarGate.moveToThisBlock()");
	}
	
	//Lövés esemény kezelése.
	@Override
	public void shootOnThisBlock(Color bulletcolor,Direction dir){
		//Ha különböző színű a létező csillagkapu, amire lövünk, mint a lövedék.
		if (bulletcolor != this.color){
			//Régi csillagkapu törlése.
			Application.maze.deleteStarGate(this.color);
			//Új csillagkapu létrehozása a régi helyén.
			Application.maze.createStarGate(this,bulletcolor,dir);
		}
		System.out.println("StarGate.shootOnThisBlock("+bulletcolor+","+dir+")");
	}
	
	//A csillagkapu párjának beállítása.
	public void setPair(int index, Direction dir){
		neighbourIndexes[dirToInt(dir)] = index;
	}
}
