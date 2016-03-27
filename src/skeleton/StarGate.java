
public class StarGate extends Wall {
	private Direction direction;
	private Color color;
	private boolean isPaired;
	
	public StarGate(Direction dir,Color col){
		super(true);  //**speciális falként inicalizálódik
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
				pair = maze.getYellowStarGate();
			}
			else{
				pair = maze.getBlueStarGate();
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
			maze.deleteStarGate(this.color);
			maze.createStarGate(this,bulletcolor,dir);
		}
		System.out.println("StarGate.shootOnThisBlock("+bulletcolor+","+dir+")");
	}

}
