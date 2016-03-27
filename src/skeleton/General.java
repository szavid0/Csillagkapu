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
	
	public AbstractBlock getPosBlock(){ return PosBlock;}
	public void setDirection(Direction dir){
		this.direction = dir;
	}
	public Direction getDirection(){
		return direction;
	}
	public void setPosBlock(AbstractBlock block){
		PosBlock = block;
	}
	public void collectZpm(Zpm modul){
		//TODO
	}
	public void die(){
		if(ZPMCnt == allZPMCnt){
			//TODO
			//Application endGame("WIN!")
		}
		else{
			//TODO
			//Application endGame("LOSE!")
		}

	}
	public boolean hasBox(){
		return boxes.size() > 0;
	}
	public Box getBox(){
		return boxes.get(boxes.size() - 1);
	}
	public void move(Direction dir){
		//TODO
	}
	public void pick(){
		//TODO
	}
	public void drop(){
		//TODO
	}
	public void shoot(Color col){
		//TODO
	}
}