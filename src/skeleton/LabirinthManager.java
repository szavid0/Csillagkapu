import java.util.List;
import java.util.ArrayList;


public class LabirinthManager {
	private List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean WormHoleExists;
	private StarGate yellowStarGate;
	private StarGate blueStarGate;
	private Field startField = new Field();
	
	private Direction oppDir(Direction dir){
		if(dir == Direction.EAST)
			dir = Direction.WEST;
		else if(dir == Direction.WEST)
			dir = Direction.EAST;
		else if(dir == Direction.NORTH)
			dir = Direction.SOUTH;
		else 
			dir = Direction.NORTH;
		
		return dir;
	}
	
	public AbstractBlock getBlock(int i){
		System.out.println("LabirinthManager.getBlock()");
		return map.get(i);
	}
	public void createStarGate(Wall w,Color col,Direction dir){
		System.out.println("LabirinthMaganger.createStarGate(w, col, dir)");
		
		if(col == Color.BLUE){
			blueStarGate = new StarGate(dir, Color.BLUE, w.getIndex());
			map.add(w.getIndex(), blueStarGate);
		}
		else{
			yellowStarGate = new StarGate(dir, Color.YELLOW, w.getIndex());
			map.add(w.getIndex(), yellowStarGate);
		}
		
	}
	public void deleteStarGate(Color col){
		System.out.println("LabirinthMaganger.deleteStarGate(col)");
		
		if(col == Color.BLUE){
			map.add(blueStarGate.getIndex(), new Wall(true, blueStarGate.getIndex()));
		}
		else{
			map.add(yellowStarGate.getIndex(), new Wall(true, yellowStarGate.getIndex()));
		}
	}
	public StarGate getYellowStarGate(){
		System.out.println("LabirinthMaganger.getYellowStarGate()");
		return yellowStarGate;
	}
	public StarGate getBlueStarGate(){
		System.out.println("LabirinthMaganger.getBlueStarGate()");
		return blueStarGate;
	}
	public Field getStartField() {
		System.out.println("LabirinthMaganger.getStartField()");
		return startField;
	}
	public void createWormHole(){
		WormHoleExists = true;
		
		yellowStarGate.setPair(blueStarGate.getIndex(), oppDir(blueStarGate.getDirection()));
		blueStarGate.setPair(yellowStarGate.getIndex(), oppDir(yellowStarGate.getDirection()));
	}
}
