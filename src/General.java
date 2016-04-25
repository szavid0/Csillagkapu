//Az ezredes osztalyanak megvalositasa.
//Az ezredest tudja iranyitani a jatekos a palyan.
import java.util.ArrayList;

public class General extends Character{
	public General(AbstractBlock pos, Direction dir){
		PosBlock = pos;
		direction = dir;
	}
	public General(){}
}