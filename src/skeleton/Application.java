
class Application {
	
	//azért staticok, mert csak egy létezik belőlük.
	public static General general = new General();
	public static LabirinthManager maze = new LabirinthManager();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static void endGame(String winOrLose){
		System.out.println("Application.endGame(" + winOrLose + ")");
	}
}
