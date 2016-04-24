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
	
	//Visszaadja a karakter iranyat.
		public Direction getDirection(){
			System.out.println("Character.getDirection()");
			return direction;
		}
		
	//Visszaadja, hogy van-e az karakternél meg doboz.
	public boolean hasBox(){
		System.out.println("Character.hasBox()");
		return box != null;
	}
	

	//Kapott szinu lovedeket lo.
	public void shoot(Color col){
		System.out.println("Character.shoot("+col+")");
		
		AbstractBlock bulletPos;
		
		for( bulletPos = PosBlock.getNeighbour(direction); bulletPos.isShootable(); bulletPos = bulletPos.getNeighbour(direction)){
			//Elmegy a lovedek, ameddig nem utkozik valamibe.
		}
		//A blokk, amibe megakadt a lovedek lekezeli, hogy ralottek.
		bulletPos.shootOnThisBlock(col, direction);
	}
	
	
	//Felveszi a dobozt, ha van elotte, es nincs nala.
		public void pick(){
			System.out.println("Character.pick()");
			AbstractBlock b = PosBlock.getNeighbour(direction);
			//Leellenorizzuk, hogy visszaad-e dobozt. Ha igen akkor felvesszuk.
			if(b.getContainsBox() && !hasBox()){
					b.getBox();
				}	
		}
	
	
	//Lerakja maga ele a dobozt, ha letudja.
	public void drop(){
		System.out.println("Character.drop()");

		AbstractBlock n = PosBlock.getNeighbour(direction);
		if(n.isPassable()  || n.getContainsBox()){ //vagy ures vagy dobozos blokkra lehet rakni
			AbstractBlock f = PosBlock.getNeighbour(direction);
			if(!(f.getClass() == Field.class) && ((Field)f).containsZpm)//nem zpm-es mezo
				if(hasBox()){f.setBox(getBox()); this.box=null;}
		}
	}

	//Visszaadja a felvett dobozt.
		public Box getBox(){
			System.out.println("Character.getBox()");
			return box;
		}

	public void move(Direction dir){
			System.out.println("General.move("+ dir +")");
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
			Application.endGame("LOSE!");
		else
			lives--;
		System.out.println("Character.die()");

	}

	public void collectZpm() {
		LabirinthManager.addZpm(this);
	}
		
		
}