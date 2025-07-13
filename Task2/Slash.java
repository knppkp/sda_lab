package Task2;

public class Slash extends Player {
    public Slash() {
        guitar = new GibsonLesPaul();
        solo = new SmashGuitar();
    }

    public void display() {
        System.out.println("I'm Slash!");
    }
}
