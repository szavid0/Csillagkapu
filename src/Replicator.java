
public class Replicator  extends Creature implements Runnable  {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Direction dir) {
		AbstractBlock n = posBlock.getNeighbour(dir);
		if(n.isPassable() || n.getContainsBox()){ //passable vagy dobozos mezo a szomszed
			posBlock.setShootable(true);
			setPosBlock(n);
			n.setShootable(false);
			n.moveToThisBlock(this);
		}
	
	}



}
