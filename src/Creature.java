import java.io.IOException;

public abstract class Creature {
	protected Direction direction;
	protected AbstractBlock PosBlock;
	protected Field startField;
	protected int weight = 0;
	public Creature(){
		this.direction = Direction.WEST;
	}
	public Creature(Direction direction, Field startField) {
		this.direction = direction;
		this.startField = startField;
	}
	public AbstractBlock getPosBlock() {
		return PosBlock;
	}
	public void setPosBlock(AbstractBlock PosBlock) {
		this.PosBlock = PosBlock;
		System.out.println(getClass().getName().toString().toUpperCase()+" ARRIVEAT "+PosBlock.getClass().getName().toString().toUpperCase()+"(ID="+PosBlock.getIndex()+")");
		Application.log.println(getClass().getName().toString().toUpperCase()+" ARRIVEAT "+PosBlock.getClass().getName().toString().toUpperCase()+"(ID="+PosBlock.getIndex()+")");
	
	}
	public Field getStartField() {
		return startField;
	}
	public int getWeight() {
		return weight;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
		System.out.println(getClass().getName().toString().toUpperCase()+" IS SET TO "+direction);  //pl: GENERAL IS SET TO WEST
		Application.log.println(getClass().getName().toString().toUpperCase()+" IS SET TO "+direction);
	}
	public abstract void move(Direction dir);
	
}
