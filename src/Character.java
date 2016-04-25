import java.io.IOException;

import javafx.scene.input.TouchPoint;
import sun.net.www.http.PosterOutputStream;

public class Character extends Creature {

	protected int lives = 3;
	protected int weight = 2;
	protected Box box;	
	


	//A Character konstruktorai.
	public Character(){
		lives=3;
		weight=2;
	}
	
	public Character(int l, int w){
	this.lives= l;
	this.weight=w;
	}
	
	public int getWeight() {
		return weight;
	}
	//Visszaadja a karakter iranyat.
		public Direction getDirection(){
			return direction;
		}
		
	//Visszaadja, hogy van-e az karaktern�l meg doboz.
	public boolean hasBox(){
		boolean b = box != null;
		System.out.println("HASBOX="+b);
		Application.log.println("HASBOX="+b);
		return b;
	}
	

	//Kapott szinu lovedeket lo.
	public void shoot(Color col){
		System.out.println(getClass().getName().toUpperCase()+" SHOOT "+col);
		Application.log.write(getClass().getName().toUpperCase()+" SHOOT "+col);

		
		AbstractBlock bulletPos;
		
		for( bulletPos = PosBlock.getNeighbour(direction); bulletPos.isShootable(); bulletPos = bulletPos.getNeighbour(direction)){
			//Elmegy a lovedek, ameddig nem utkozik valamibe.
		}
		//A blokk, amibe megakadt a lovedek lekezeli, hogy ralottek.
		bulletPos.shootOnThisBlock(col, direction);
	}
	
	
	//Felveszi a dobozt, ha van elotte, es nincs nala.
		public void pick(){
			System.out.println(getClass().getName().toUpperCase()+" PICK");
			AbstractBlock b = PosBlock.getNeighbour(direction);
			//Leellenorizzuk, hogy visszaad-e dobozt. Ha igen akkor felvesszuk.
			if(b.getContainsBox() && !hasBox()){
					b.getBox();
				}	
		}
	
	
	//Lerakja maga ele a dobozt, ha letudja.
	public void drop(){

		AbstractBlock f = PosBlock.getNeighbour(direction);
		if(f.isPassable()  || f.getContainsBox()) //vagy ures vagy dobozos blokkra lehet rakni
			if(!(f.getClass() == Field.class) && ((Field)f).containsZpm)
				if(hasBox()){
					System.out.println(getClass().getName().toUpperCase()+ " DROPPED BOX ON "+f.getClass().getName().toUpperCase()+"ID=(+"+f.getIndex()+")");
					Application.log.println(getClass().getName().toUpperCase()+ " DROPPED BOX ON "+f.getClass().getName().toUpperCase()+"ID=(+"+f.getIndex()+")");

					
					f.setBox(getBox());
					this.box=null;
				}
		
	}

	//Visszaadja a felvett dobozt.
		public Box getBox(){
			return box;
		}

	public void move(Direction dir){
			System.out.println("MOVE "+getClass().getName().toUpperCase()+" "+ dir);
			direction = dir;
				AbstractBlock block = PosBlock.getNeighbour(dir);
				//Ha ra lehet lepni, akkor beallitjuk a pozicionak.
				//Az eddigi blokkot pedig ertesitjuk, hogy elleptunk rola.
				if(block.isPassable()){
					PosBlock.notifyBlock();	
					block.moveToThisBlock(this);
			}
	}
	public void die(){
		//Megnezi, hogy van e meg vesztheto elete, ha nincs jelezzuk, hogy vesztett a jatekos.
	

		if(lives ==	0)
			Application.endGame("LOSE");
		else
			lives--;
		System.out.println(getClass().getName().toUpperCase()+ " DIE LIVES="+lives);
		Application.log.println(getClass().getName().toUpperCase()+ " DIE LIVES="+lives);
	
	}

	public void collectZpm() {
		LabirinthManager.addZpm(this);
	}
		
		
}