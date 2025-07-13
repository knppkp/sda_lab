package Task2;

public abstract class Player {
    protected GuitarBehavior guitar;
    protected SoloBehavior solo;

    public void setGuitar(GuitarBehavior guitar) {
        this.guitar = guitar;
    }

    public void setSolo(SoloBehavior solo) {
        this.solo = solo;
    }

    public void playGuitar() {
        guitar.playGuitar();
    }

    public void performSolo() {
        solo.performSolo();
    }

    public abstract void display();
}
