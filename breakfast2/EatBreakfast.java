package breakfast2;

public class EatBreakfast {
	public static void main(String[] args) {
		System.out.println("Cooking scramble egg...");
		ScrambledEggs scrambled = new ScrambledEggs();
		scrambled.cooking(2);
		System.out.println("\n");

		System.out.println("Cooking omelette...");
		Omelette omelette = new Omelette();
		omelette.cooking(3);
		System.out.println("\n");
		
		System.out.println("Cooking sunny side...");
		SunnySide sunny = new SunnySide();
		sunny.cooking(1);
		System.out.println("\n");
	}

}
