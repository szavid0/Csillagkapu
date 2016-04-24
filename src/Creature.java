
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
		System.out.println(getClass().toString().toUpperCase()+" ARRIVEAT "+PosBlock.getClass().toString().toUpperCase()+"(ID="+PosBlock.getIndex()+")");
		this.PosBlock = PosBlock;
	}
	public Field getStartField() {
		return startField;
	}
	public int getWeight() {
		return weight;
	}
	public void setDirection(Direction direction) {
		System.out.println(getClass().toString().toUpperCase()+" IS SET TO "+direction);  //pl: GENERAL IS SET TO WEST
		this.direction = direction;
	}
	public abstract void move(Direction dir);
	
}
