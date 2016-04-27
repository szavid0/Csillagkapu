import java.io.IOException;

//Merleg osztaly megvalositasa, a mezobol oroklodik.
public class Scale extends Field {
	//A merleghez tartozo ajto.
	private Door doorToOpen;
	//Suly, ami hatasara nyilik a hozza tartozo ajto.
	private int weightlimit;
	//A rajta levo sulyt tartolja.
	private int currentWeight = 0;
	
	//Konstruktor.
	public Scale(int id,int[] n){
		super(id,n);
		passable=true;
	}
	
	//Konstruktor. DoorToOpen-t es sulylimitet, passable-t allitja.
	public Scale(int id,int[] n,Door d,int weightlimit,boolean hasBox,boolean hasZpm){
		super(id,n,hasBox,hasZpm);
		this.weightlimit = weightlimit;
		this.doorToOpen=d;
		//Ha van rajta doboz, akkor nem passable.
		if(hasBox){
			passable=false;
			boxes.add(new Box(1));
		}
	}
	
	//Az ezredes ralep, ha nincs rajta doboz es osszegyujti a ZPM-et, ha van rajta. Ajtot nyit megfelelo sulyra.
	@Override
	public void moveToThisBlock(Character c){

		c.setPosBlock(this);
		System.out.println("WEIGHT ON SCALE="+c.getWeight()+" WEIGHTLIMIT="+weightlimit);
		Application.log.println("WEIGHT ON SCALE="+c.getWeight()+" WEIGHTLIMIT="+weightlimit);
		//Ha megfelelo suly van rajta, ajtot nyit.
		if (c.getWeight() >= weightlimit){
				doorToOpen.Open(true);
			}		
	}
	
	//Doboz merlegre rakasa, ajto nyitasa. Passable, shootable allitasa.
	@Override
	public void setBox(Box box){
		boxes.add(box);
		passable = false;
		shootable = false;
		containsBox = true;
		currentWeight += box.getWeight();
		System.out.println("WEIGHT ON SCALE="+currentWeight+" WEIGHTLIMIT="+weightlimit);
		Application.log.println("WEIGHT ON SCALE="+currentWeight+" WEIGHTLIMIT="+weightlimit);
		//Ha megfelelo suly van rajta, ajtot nyit.
		if(currentWeight >= weightlimit)
			doorToOpen.Open(true);
	}
	
	//Doboz merlegrol levetele, ajto zarasa.
	@Override
	public Box getBox(){
		if(getContainsBox()){
			if(boxes.size()==1){
				//Passable, shootable igaz, ha 1 doboz volt rajta es levettek.
				passable = true;
				shootable = true;
				System.out.println("COLLECTBOX");
				Application.log.println("COLLECTBOX");
			}
			Box box = boxes.remove(boxes.size()-1);
			//A doboz sulyaval csokkentjuk a merlegen levo sulyt.
			currentWeight -= box.getWeight();
			System.out.println("WEIGHT ON SCALE="+currentWeight+" WEIGHTLIMIT="+weightlimit);
			Application.log.println("WEIGHT ON SCALE="+currentWeight+" WEIGHTLIMIT="+weightlimit);
			//Ha nincs eleg suly a merlegen, az ajto bezarul.
			if(currentWeight < weightlimit)
				doorToOpen.Open(false);
			return box;
		}
		return null;
	}
	
	//Lelepes esemeny ertesitesere. Ajtot bezarja.
	@Override
	public void notifyBlock(){
		System.out.println("NOTIFY SCALE");
		Application.log.println("NOTIFY SCALE");
		doorToOpen.Open(false);
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s += " WEIGHT:"+currentWeight+" WEIGHTLIMIT:"+weightlimit+" DOOR:"+doorToOpen.getIndex();
		return s;
	}
}