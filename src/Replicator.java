
public class Replicator  extends Creature implements Runnable  {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Direction dir) {
		System.out.println("MOVE "+getClass().toString().toUpperCase()+" "+dir);
		AbstractBlock n = PosBlock.getNeighbour(dir);
		if(n.isPassable() || n.getContainsBox()){ //passable vagy dobozos mezo a szomszed
			PosBlock.setShootable(true);
			setPosBlock(n);
			n.setShootable(false);
			n.moveToThisBlock(this);
		}
	}

}
