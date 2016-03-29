
public class StarGate extends Wall {
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
	
	public StarGate(int index,int[] neighbours,Direction dir,Color col){
		super(index,neighbours,true);  //**speciális falként inicalizálódik
		this.direction=dir;
		this.color=col;
	}
	public boolean getIsPaired(){
		System.out.println("StarGate.getIsPaired()");
		return isPaired;
	}
	public Direction getDirection(){
		System.out.println("StarGate.getDirection()");
		return direction;
	}
	public Color getColor(){
		System.out.println("StarGate.getColor()");
		return color;
	}

	@Override
	public void moveToThisBlock(){
		System.out.println("StarGate.moveToThisBlock()");
		if(isPaired){
			StarGate pair = null;
			if(color == Color.BLUE) {
				pair = Application.maze.getYellowStarGate();
			}
			else{
				pair = Application.maze.getBlueStarGate();
			}
			Direction dir = pair.getDirection();
			AbstractBlock neighbour = pair.getNeighbour(dir);	
			Application.general.setPosBlock(neighbour);
			Application.general.setDirection(dir);
		}
	}
	@Override
	public void shootOnThisBlock(Color bulletcolor,Direction dir){
		System.out.println("StarGate.shootOnThisBlock("+bulletcolor+","+dir+")");
		if (bulletcolor != this.color){
			Application.maze.deleteStarGate(this.color);
			Application.maze.createStarGate(this,bulletcolor,Application.maze.oppDir(dir));
		}
	}
	public void setPair(int index, Direction dir){
		neighbourIndexes[dirToInt(dir)] = index;
	}
}
