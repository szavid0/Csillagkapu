//Az ezredes osztalyanak megvalositasa.
//Az ezredest tudja iranyitani az egyik jatekos a palyan.
import java.util.ArrayList;
//A Character osztalybol szarmazik.
public class General extends Character{
	public General(AbstractBlock pos, Direction dir,Boolean hasbox){
		//Az ezredes pozicioja es iranya.
		PosBlock = pos;
		direction = dir;
		//Van-e doboz az ezredesnel.
		if(hasbox)
			this.box = new Box(2);
	}
	public General(){}
}