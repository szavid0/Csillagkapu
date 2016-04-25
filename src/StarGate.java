import java.io.IOException;

//A csillagkapu osztaly megvalositasa, a falbol oroklodik.
public class StarGate extends Wall {
	//Irany, szin, van-e csillagkapu parja meghatarozasa.
	private Direction direction;
	private Color color;
	private boolean isPaired;
	
	public StarGate(int index,int[] neighbours,Direction dir,Color color,boolean isPaired){
		super(index,neighbours);
		this.direction = dir;
		this.color = color;
		this.isPaired = isPaired;
		if (isPaired){
			passable=true;
		}
		else{
			passable=false;
		}
	}
	
	//Csillagkapu iranyanak atkonvertalasa integer-re.
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
	
	//Konstruktor, beallitja az iranyt, szint es indexet.
	public StarGate(int index,int[] neighbours,Direction dir,Color col){
		super(index,neighbours,true);  //**specialis falkent inicalizalodik
		this.direction=dir;
		this.color=col;
	}
	
	//Visszaadja, hogy van-e parja.
	public boolean getIsPaired(){
		return isPaired;
	}
	
	//Visszaadja az iranyat.
	public Direction getDirection(){
		return direction;
	}
	
	//Visszaadja a szinet.
	public Color getColor(){
		return color;
	}

	//Ralepes esemeny kezelese.
	@Override
	public void moveToThisBlock(Character c){
		//Ha van parja, megkeressuk.
		//Ha nincs, akkor nem csinalunk semmit.
		if(isPaired){
			StarGate pair = null;
			if(color == Color.BLUE) {
				//Sarga par.
				pair = Application.maze.getYellowStarGate();
			}
			else if(color == Color.YELLOW){
				//Kek par.
				pair = Application.maze.getBlueStarGate();
			}else if(color == Color.RED){
				pair = Application.maze.getGreenStarGate();
			}else{
				pair = Application.maze.getRedStarGate();
			}
			//Lekeri a parjanak az iranyat es az ott levo szomszedot.
			Direction dir = pair.getDirection();
			AbstractBlock neighbour = pair.getNeighbour(dir);	
			//Atlepunk arra a blockra es beallitjuk az ezredes iranyat.
			c.setPosBlock(neighbour);
			c.setDirection(dir);
		}
	}
	
	//Loves esemeny kezelese.
	@Override
	public void shootOnThisBlock(Color bulletcolor,Direction dir){
		System.out.println(bulletcolor + " BULLET HIT STARGATE(ID="+index+",COLOR="+color+")");
		Application.log.println(bulletcolor + " BULLET HIT STARGATE(ID="+index+",COLOR="+color+")");

		//Ha kulonbozo szinu a letezo csillagkapu, amire lovunk, mint a lovedek.
		if (bulletcolor != this.color){
			//Regi csillagkapu torlese.
			Application.maze.deleteStarGate(this.color);
			//Uj csillagkapu letrehozasa a regi helyen.
			Application.maze.createStarGate(this,bulletcolor,Application.maze.oppDir(dir));
		}
	}
	
	//A csillagkapu parjanak beallitasa.
	public void setPair(int index, Direction dir){
		neighbourIndexes[dirToInt(dir)] = index;
	}
}