
import java.io.IOException;

public class Replicator  extends Creature implements Runnable  {
	//Replicator konstruktora
	public Replicator(AbstractBlock pos, Direction dir){
		PosBlock = pos;
		PosBlock.setShootable(false);
		direction = dir;
	}
	public Replicator(){}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Replicator mozgasat leiro fuggveny
	public void move(Direction dir) {
		Direction random_dir;
		AbstractBlock n;
		
		//Random modban kerunk egy random iranyt
		if(Application.random == true){
			random_dir = Application.maze.getRandomDirection();
			 n = PosBlock.getNeighbour(random_dir);
		}else{
			n = PosBlock.getNeighbour(dir);
		}
		
		if(n.isPassable() || n.getContainsBox()){ //passable vagy dobozos mezo a szomszed
			PosBlock.setShootable(true);
			setPosBlock(n);
			n.setShootable(false);
			n.moveToThisBlock(this);
		}
	}

}