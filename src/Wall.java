import java.io.IOException;

import com.sun.org.apache.bcel.internal.generic.RETURN;

//Fal osztaly megvalositasa, AbstractBlockbol oroklodik.
public class Wall extends AbstractBlock {
	//Specialis fal-e, melyre love csillagkapu alakul ki.
	protected boolean isSpecial;
	
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
		shootable = false;
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
				System.out.println(col+" BULLET HIT SPECIALWALL(ID="+index+")");
				Application.log.println(col+" BULLET HIT SPECIALWALL(ID="+index+")");
				Application.maze.createStarGate(this, col, Application.maze.oppDir(dir));
			
				return;
			}
			System.out.println(col+" BULLET HIT WALL(ID="+index+")");
			Application.log.println(col+" BULLET HIT WALL(ID="+index+")");


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
	@Override
	public String toString() {
		return super.toString()+" SPECIAL:"+ Boolean.toString(isSpecial).toUpperCase();
	}
}