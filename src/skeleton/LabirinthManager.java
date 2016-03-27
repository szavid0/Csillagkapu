import java.util.List;
import java.util.ArrayList;


public class LabirinthManager {
	private List<AbstractBlock> map = new ArrayList<AbstractBlock>();
	private boolean WormHoleExists;
	private StarGate yellowStarGate;
	private StarGate blueStarGate;
	private Field startField = new Field();
	
	public AbstractBlock getBlock(int i){
		return map.get(i);
	}
	public void createStarGate(Wall w,Color col,Direction dir){
		//TODO ***
	}
	public void deleteStarGate(Color col){
		//TODO ***
	}

	public StarGate getYellowStarGate(){
		return yellowStarGate;
	}
	public StarGate getBlueStarGate(){
		return blueStarGate;
	}
	public Field getStartField() {
		return startField;
	}
	

}
