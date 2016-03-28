import java.util.ArrayList;

public class General {
	private AbstractBlock PosBlock;
	private Direction direction;
	private int lives;
	private int ZPMCnt;
	private int allZPMCnt;
	private ArrayList<Box> boxes;
	
	public General(){
		lives = 3;
		ZPMCnt = 0;
		boxes = new ArrayList<Box>();
	}
	
	public AbstractBlock getPosBlock(){ 
		System.out.println("General.getPosBlock()");
		return PosBlock;
	}
	public void setDirection(Direction dir){
		System.out.println("General.setDirection("+ dir +")");
		this.direction = dir;
	}
	public Direction getDirection(){
		System.out.println("General.getDirection()");
		return direction;
	}
	public void setPosBlock(AbstractBlock block){
		System.out.println("General.setPosBlock(block)");
		PosBlock = block;
	}
	public void collectZpm(Zpm modul){
		System.out.println("General.collectZPM(ZPM modul)");
		//TODO
	}
	public void die(){
		if(ZPMCnt == allZPMCnt){
			Application.endGame("WIN!");
		}
		else{
			Application.endGame("LOSE!");
		}
		System.out.println("General.die()");

	}
	public boolean hasBox(){
		System.out.println("General.hasBox()");
		return boxes.size() > 0;
	}
	public Box getBox(){
		System.out.println("General.getBox()");
		return boxes.get(boxes.size() - 1);
	}
	public void move(Direction dir){
		System.out.println("General.move("+ dir +")");
		
		AbstractBlock block = PosBlock.getNeighbour(dir);
		
		if(block.isPassable())
			block.moveToThisBlock();
	}
	public void pick(){
		System.out.println("General.pick()");
		
		//kérdéses!
		Field f = (Field)PosBlock.getNeighbour(direction);
		if(f.getContainsBox()){
			boxes.add(f.getBox());
		}
	}
	public void drop(){
		System.out.println("General.drop()");
		//TODO
	}
	public void shoot(Color col){
		System.out.println("General.shoot()");
		//TODO
	}
}