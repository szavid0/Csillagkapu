
public class StarGate extends Wall {
	private Direction direction;
	private Color color;
	private boolean isPaired;
	
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
	
	public StarGate(Direction dir,Color col, int index){
		super(true, index);  //**speciális falként inicalizálódik
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
		if(isPaired){
			StarGate pair = null;
			if(color == Color.BLUE) {
				pair = Application.maze.getYellowStarGate();
			}
			else{
				pair = Application.maze.getBlueStarGate();
			}
			Direction dir = pair.getDirection();
			AbstractBlock neighbour = pair.getNeighbour(direction);	
			Application.general.setPosBlock(neighbour);
			Application.general.setDirection(dir);
		}
		System.out.println("StarGate.moveToThisBlock()");
	}
	@Override
	public void shootOnThisBlock(Color bulletcolor,Direction dir){
		if (bulletcolor != this.color){
			Application.maze.deleteStarGate(this.color);
			Application.maze.createStarGate(this,bulletcolor,dir);
		}
		System.out.println("StarGate.shootOnThisBlock("+bulletcolor+","+dir+")");
	}
	public void setPair(int index, Direction dir){
		neighbourIndexes[dirToInt(dir)] = index;
	}
}
