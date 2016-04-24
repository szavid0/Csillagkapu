import java.io.IOException;

//Ajto osztaly megvalositasa, AbstractBlock-bol oroklodik.
public class Door extends AbstractBlock {
	//Konstruktor.
	public Door(int index,int[]neighbours){
		super(index,neighbours);
		passable=false;
	}
	
	//Nyitas fuggveny, athaladhatosag beallitasra kerul.
	public void Open(boolean tf){
		if(tf == true){
			System.out.println("OPEN DOOR(ID="+index+")");
			try {
				Application.log.write("OPEN DOOR(ID="+index+")");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("CLOSE DOOR(ID="+index+")");
			try {
				Application.log.write("CLOSE DOOR(ID="+index+")");
			} catch (IOException e) {
				e.printStackTrace();
			}
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
		try {
			Application.log.write(col+" BULLET HIT DOOR(ID="+index+")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Nem szukseges a jelzes neki, igy nem csinal semmit.
	@Override
	public void notifyBlock() {		
	}
	

	@Override
	public void moveToThisBlock(Replicator r) {
			r.setPosBlock(this);
	}
	
}