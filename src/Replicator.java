import java.io.IOException;

public class Replicator  extends Creature implements Runnable  {
	
	public Replicator(AbstractBlock pos, Direction dir){
		PosBlock = pos;
		direction = dir;
	}
	public Replicator(){}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Direction dir) {
		System.out.println("MOVE "+getClass().getName().toUpperCase()+" "+dir);
		Application.log.write("MOVE "+getClass().getName().toUpperCase()+" "+dir);

		
		AbstractBlock n = PosBlock.getNeighbour(dir);
		if(n.isPassable() || n.getContainsBox()){ //passable vagy dobozos mezo a szomszed
			PosBlock.setShootable(true);
			setPosBlock(n);
			n.setShootable(false);
			n.moveToThisBlock(this);
		}
	}

}
