import java.io.IOException;

public abstract class Creature {
	protected Direction direction;
	protected AbstractBlock PosBlock;
	protected Field startField;
	protected int weight;
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
		System.out.println(getClass().getName().toUpperCase()+" ARRIVEAT "+PosBlock.getClass().getName().toUpperCase()+"(ID="+PosBlock.getIndex()+")");
		Application.log.println(getClass().getName().toUpperCase()+" ARRIVEAT "+PosBlock.getClass().getName().toUpperCase()+"(ID="+PosBlock.getIndex()+")");
	}
	public Field getStartField() {
		return startField;
	}

	public void setDirection(Direction direction) {
		System.out.println(getClass().getName().toUpperCase()+" IS SET TO "+direction); 
		Application.log.println(getClass().getName().toUpperCase()+" IS SET TO "+direction);

		this.direction = direction;
	}
	public abstract void move(Direction dir);
	
}
