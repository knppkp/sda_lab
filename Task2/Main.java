package Task2;

public class Main {
    public static void main(String[] args) {
        Player player = new Slash();
        player.display();
        player.playGuitar();
        player.performSolo();

        System.out.println("\nSwitching behavior...");

        player.setGuitar(new FenderTelecaster());
        player.setSolo(new JumpOffStage());

        player.playGuitar();
        player.performSolo();
    }
}