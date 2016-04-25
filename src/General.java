//Az ezredes osztalyanak megvalositasa.
//Az ezredest tudja iranyitani a jatekos a palyan.
import java.util.ArrayList;

public class General extends Character{
	public General(AbstractBlock pos, Direction dir,Boolean hasbox){
		PosBlock = pos;
		direction = dir;
		if(hasbox)
			this.box = new Box(1);
	}
	public General(){}
}