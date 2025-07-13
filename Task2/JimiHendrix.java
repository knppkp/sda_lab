package Task2;

public class JimiHendrix extends Player {
    public JimiHendrix() {
        guitar = new FenderTelecaster();
        solo = new GuitarOnFire();
    }

    public void display() {
        System.out.println("I'm Jimi Hendrix!");
    }
}