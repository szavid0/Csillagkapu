import com.sun.org.apache.bcel.internal.generic.RETURN;

//Fal osztaly megvalositasa, AbstractBlockbol oroklodik.
public class Wall extends AbstractBlock {
	//Specialis fal-e, melyre love csillagkapu alakul ki.
	private boolean isSpecial;
	
	//Konstruktor.
	public Wall(int id,int[] n){
		super(id,n);
	}
	
	//Konstruktor, beallitja az isSpecial-t, athaladhatosagot es az index erteket.
	public Wall(int id,int[] neighbours,boolean isSpecial){
		super(id,neighbours);
		this.isSpecial=isSpecial;
		this.index = id;
		passable = false;
	}
	
	//Visszaadja a szomszedokat.
	public int[] getNeighboursIndex(){
		return neighbourIndexes;
	}
	
	//Falra nem lehet lepni.
	@Override
	public void moveToThisBlock(Character c) {
	}
	
	//Specialis fal eseten raloves kezelese.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
			if (isSpecial){
			Application.maze.createStarGate(this, col, Application.maze.oppDir(dir));
			System.out.println(col+" BULLET HIT SPECIALWALL(ID="+index+")");
			return;
			}
			System.out.println(col+" BULLET HIT WALL(ID="+index+")");

	}
	
	//Nem szukseges a jelzes neki, igy nem csinal semmit.
	@Override
	public void notifyBlock() {
	}
	
	//Null erteket ad vissza, hisz nem lehet rajta doboz.
	@Override
	public Box getBox() {
		return null;
	}
	
	public void setBox(Box box){
	}

	@Override
	public void moveToThisBlock(Replicator creature) {
		
	}
}