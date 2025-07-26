package breakfast2;

public abstract class CookingEgg {

    public final void cooking(int numOfEggs) {
        crackEgg(numOfEggs);
        prepareEgg();
        cookEgg();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        serveEgg();
    }

    abstract void prepareEgg();

    abstract void cookEgg();

    abstract void addCondiments();

    public boolean customerWantsCondiments() {
        return true;
    }

    final void crackEgg(int numOfEggs) {
        System.out.println("Cracking " + numOfEggs + " eggs");
    }

    final void serveEgg() {
        System.out.println("placing the eggs on the plate");
    }
}
