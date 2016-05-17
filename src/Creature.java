import java.awt.Graphics;
import java.io.IOException;
import java.io.Serializable;

public abstract class Creature implements Serializable{
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
	@Override
	public String toString() {
		return getClass().getName().toUpperCase()+","+PosBlock.getIndex()+","+direction;
	}
	/**
	 * Kirajzolja az adott karaktert a palyara
	 * A karakter iranyat egy kis vonal jelzi
	 * @param g
	 */
	public void draw(Graphics g){
		if(this.getClass() == General.class){
			g.setColor(new java.awt.Color(0,204,0));	//general szin
		}else if(this.getClass() == Jaffa.class){
			g.setColor(new java.awt.Color(230,150,0)); //jaffa szin
		}else
			g.setColor(new java.awt.Color(204,0,0));	//replicator szin
		
		int x = PosBlock.getIndex() % 10; //oszlopindex
		int y = PosBlock.getIndex() / 10;  //sorindex
		
		GamePanel p = Application.app.getGamePanel();
		int rectWidth = p.rectWidth;
		int rectHeight = p.rectHeight;
		int marginV = p.marginV;
		int marginH = p.marginH;

		//karakter abrazolasa
		g.fillOval(marginV + (x * rectWidth), marginH + (y * rectHeight),(int)( rectWidth*0.85), (int)(rectHeight*0.85));		
		
		
	}

}
