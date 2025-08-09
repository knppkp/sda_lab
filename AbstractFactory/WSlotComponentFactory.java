package AbstractFactory;

public class WSlotComponentFactory implements SlotComponentFactory {

	private final SlotType type;

    public WSlotComponentFactory(SlotType type) {
        this.type = type;
    }

    public Cabinet createCabinet() {
        return switch (type) {
            case straight, progressive -> new largeCabinet();
            case bonus -> new mediumCabinet();
        };
    }

    public Display createDisplay() {
        return switch (type) {
            case straight, progressive -> new Reels();
            case bonus -> new VGA();
        };
    }

    public Payment createPayment() {
        return switch (type) {
            case straight -> new Bills();
            case bonus -> new Ticket();
            case progressive -> new Coins();
        };
    }

    public GPU createGPU() {
        return new ARM();
    }

    public OS createOS() {
        return switch (type) {
            case straight -> new Linux();
            case bonus -> new Symbian();
            case progressive -> new Android();
        };
    }
}
