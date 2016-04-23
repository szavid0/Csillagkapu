
public abstract class Creature {
	protected Direction direction;
	protected AbstractBlock posBlock;
	protected Field startField;
	protected int weight = 0;
	public AbstractBlock getPosBlock() {
		return posBlock;
	}
	public void setPosBlock(AbstractBlock posBlock) {
		this.posBlock = posBlock;
	}
	public Field getStartField() {
		return startField;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public abstract void move(Direction dir);
	public  void die(){}
	
}
