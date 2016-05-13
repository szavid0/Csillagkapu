
import java.io.IOException;

public class Replicator  extends Creature implements Runnable  {
	boolean stop = false;
	
	//Replicator konstruktora
	public Replicator(AbstractBlock pos, Direction dir){
		PosBlock = pos;
		PosBlock.setShootable(false);
		direction = dir;
	}
	public Replicator(){}
	
	/**
	 * A replikator viselkedese: 
	 * lep egyet veletlenszeruen majd 1 mp-et alszik es ujra lep
	 */
	@Override
	public void run() {
		while(!stop){
			move();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void stop(){
		stop = true;
	}
	
	/**
	 * Replicator veletlenszeru mozgatasa
	 * Eloszor leker egy veletlen iranyt, majd megnezi, hogy lehet-e lepni az adott mezore
	 * Ha igen odalep
	 */
	public synchronized void move() {		
			Direction random_dir = Application.maze.getRandomDirection();
			AbstractBlock n = PosBlock.getNeighbour(random_dir);
	
		if(n.isPassable() || n.getContainsBox()){ //passable vagy dobozos mezo a szomszed
			PosBlock.setShootable(true);
			setPosBlock(n);
			n.setShootable(false);
			n.moveToThisBlock(this);
		}
	}

}