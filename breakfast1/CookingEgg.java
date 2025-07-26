package breakfast1;

public abstract class CookingEgg {
    public final void cooking(int numOfEggs) {
        crackEgg(numOfEggs);
        prepareEgg();
        cookEgg();
        serveEgg();
    }

    abstract void prepareEgg();

    abstract void cookEgg();

    final void crackEgg(int numOfEggs) {
        System.out.println("Cracking " + numOfEggs +  " eggs");
    }

    final void serveEgg() {
		System.out.println("placing the eggs on the plate");
	}
}