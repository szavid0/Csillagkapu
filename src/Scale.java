//Merleg osztaly megvalositasa, a mezobol oroklodik.
public class Scale extends Field {
	//A merleghez tartozo ajto.
	private Door doorToOpen;
	private int weightlimit;
	private int currentWeight = 0;
	
	//Konstruktor.
	public Scale(int id,int[] n){
		super(id,n);
		passable=true;
	}
	
	//Konstruktor. DoorToOpen-t allitja.
	public Scale(int id,int[] n,Door d,int weightlimit,boolean hasBox,boolean hasZpm){
		super(id,n,hasBox,hasZpm);
		this.weightlimit = weightlimit;
		this.doorToOpen=d;
		if(hasBox){
			passable=false;
			boxes.add(new Box(1));
		}
	}
	
	//Az ezredes ralep, ha nincs rajta doboz es osszegyujti a ZPM-et, ha van rajta. Ajtot nyit.
	@Override
	public void moveToThisBlock(Character c){
		System.out.println("Scale.moveToThisBlock()");
		c.setPosBlock(this);
			if (c.getWeight() >= weightlimit){
				doorToOpen.Open(true);
			}
	}
	
	//Doboz merlegre rakasa, ajto nyitasa.
	@Override
	public void setBox(Box box){
		System.out.println("Scale.setBox(box)");
		boxes.add(box);
		currentWeight += box.getWeight();
		if(currentWeight >= weightlimit)
			doorToOpen.Open(true);
	}
	
	//Doboz merlegrol levetele, ajto zarasa.
	@Override
	public Box getBox(){
		System.out.println("Scale.getBox()");
		if(getContainsBox()){
			Box box = boxes.get(boxes.size()-1);
			currentWeight -= box.getWeight();
			if(currentWeight < weightlimit)
				doorToOpen.Open(false);
			return box;
		}
		return null;
	}
	
	//Lelepes esemeny ertesitesere. Ajtot bezarja.
	@Override
	public void notifyBlock(){
		System.out.println("Scale.notifyBlock()");
		doorToOpen.Open(false);
	}
}