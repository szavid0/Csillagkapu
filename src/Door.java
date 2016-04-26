import java.io.IOException;

//Ajto osztaly megvalositasa, AbstractBlock-bol oroklodik.
public class Door extends AbstractBlock {
	//Konstruktor.
	public Door(int index,int[]neighbours){
		super(index,neighbours);
		//Nem athaladhato.
		passable=false;
		shootable = false;
	}
	
	//Nyitas fuggveny, athaladhatosag beallitasra kerul.
	public void Open(boolean tf){
		if(tf == true){
			System.out.println("OPEN DOOR(ID="+index+")");
			Application.log.println("OPEN DOOR(ID="+index+")");
		}
		else {
			System.out.println("CLOSE DOOR(ID="+index+")");
			Application.log.println("CLOSE DOOR(ID="+index+")");
		}
		passable=tf;
	}
	
	//Ralepes esemeny, ha athaladhatosag engedelyezve van, a pozicio erre az elemre valtozik.
	@Override
	public void moveToThisBlock(Character c) {
		c.setPosBlock(this);	
	}
	
	//Loves kezelese az ajtonal.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {		
		System.out.println(col+" BULLET HIT DOOR(ID="+index+")");
		Application.log.println(col+" BULLET HIT DOOR(ID="+index+")");

	}
	
	//Nem szukseges a jelzes neki, igy nem csinal semmit.
	@Override
	public void notifyBlock() {		
	}
	
	//Ha a replikator ralep, akkor jelzi.
	@Override
	public void moveToThisBlock(Replicator r) {
			r.setPosBlock(this);
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		if(passable) s+= " OPEN";
		else s += " CLOSED";
		return s;
	}	
}