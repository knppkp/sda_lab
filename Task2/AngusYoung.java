package Task2;

public class AngusYoung extends Player {
    public AngusYoung() {
        guitar = new GibsonSG();
        solo = new JumpOffStage();
    }

    public void display() {
        System.out.println("I'm Angus Young!");
    }
}