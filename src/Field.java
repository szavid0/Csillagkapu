import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Mezo osztaly megvalositasa, AbstractBlockbol oroklodik.
public class Field extends AbstractBlock {
	//Letaroljuk, tartalmaz-e ZPM modult vagy dobozt.
	protected boolean containsZpm = false;
	protected boolean containsBox = false;
	protected List<Box> boxes = new ArrayList<Box>();
	
	//Konstruktor.
	public Field(int id,int[] neighbours){
		super(id,neighbours);
		 passable=true;
	}
	
	//Parameterezett konstruktor.
	public Field(int id,int[] neighbours,boolean hasBox,boolean hasZpm){
		super(id,neighbours);
		//Ha van a mezon doboz, akkor nem athaladhato.
		if(hasBox){
			this.containsBox = true;
			passable = false;
			boxes.add(new Box(1));
		}
		//Ha nincs a mezon doboz, akkor athaladhato.
		else{
			passable = true;
		}
		//Zpm van a mezon.
		if(hasZpm){
			this.containsZpm = true;
		}
		
	}
	
	//Visszaadja van-e rajta doboz.
	public boolean getContainsBox(){
		return containsBox;
	}
	
	//Visszaadja van-e rajta ZPM modul.
	public boolean getContainsZpm(){
		return containsZpm;
	}
	
	//Visszaadja a rajta tarolt dobozt.
	@Override
	public Box getBox(){
		if(getContainsBox()){
			if(boxes.size() == 1){
				passable = true;
				shootable = true;
			}
			return boxes.get(boxes.size()-1);
		}
		return null;
	}
	
	//Rarak egy dobozt a mezore.
	@Override
	public void setBox(Box box){
		boxes.add(box);
		passable = false;
		shootable = false;
	}
	
	//Az ezredes ralep, ha nincs rajta doboz es osszegyujti a ZPM-et, ha van rajta.
	@Override
	public void moveToThisBlock(Character c) {
			c.setPosBlock(this);
			if(containsZpm == true){
				c.collectZpm();
				containsZpm = false;
		}
	}
	
	//Lovesnel megadja a lovedek helyzetet, iranyat, szinet.
	@Override
	public void shootOnThisBlock(Color col, Direction dir) {
		System.out.println(col+" BULLET HIT "+getClass().getName().toString().toUpperCase()+"(ID="+index+")");
		Application.log.println(col+" BULLET HIT "+getClass().getName().toString().toUpperCase()+"(ID="+index+")");

	}

	//Nem szukseges a jelzes neki, igy nem csinal semmit.
	@Override
	public void notifyBlock() {
	}

	@Override
	public void moveToThisBlock(Replicator r) {
		r.setPosBlock(this);
	}

	public void setZpm() {
		System.out.println("PUTZPM "+index);
		Application.log.println("PUTZPM "+index);

		containsZpm = true;
	}


}