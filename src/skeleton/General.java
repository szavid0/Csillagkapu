import java.util.ArrayList;

public class General {
	private AbstractBlock PosBlock;
	private Direction direction;
	private int lives;
	private int ZPMCnt;
	private int allZPMCnt;
	private ArrayList<Box> boxes;
	
	public General(){
		System.out.println("General constructor");
		
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
	public void collectZpm(){ //nem kell megkapja magát a modult
		System.out.println("General.collectZPM()");
		
		ZPMCnt++;
		if(ZPMCnt == allZPMCnt)
			Application.endGame("WIN!");
	}
	public void die(){
		if(lives ==	0)
			Application.endGame("LOSE!");
		else
			lives--;
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
		
		if(block.isPassable()){
			block.notifyBlock();
			block.moveToThisBlock();
		}
			
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
		
		Field f = (Field)PosBlock.getNeighbour(direction);
		if(!f.getContainsBox()){
			if(hasBox())
				f.setBox(getBox());;
		}
	}
	public void shoot(Color col){
		System.out.println("General.shoot()");
		
		AbstractBlock bulletPos;
		
		for( bulletPos = PosBlock.getNeighbour(direction); bulletPos.isPassable(); bulletPos = bulletPos.getNeighbour(direction)){
			//elmegy a lövedék a falig.
		}
		
		bulletPos.shootOnThisBlock(col, direction);
	}
}