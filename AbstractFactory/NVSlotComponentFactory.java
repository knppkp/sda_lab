package AbstractFactory;

public class NVSlotComponentFactory implements SlotComponentFactory {

	private final SlotType type;

    public NVSlotComponentFactory(SlotType type) {
        this.type = type;
    }

    public Cabinet createCabinet() {
        return switch (type) {
            case straight -> new largeCabinet();
            case bonus -> new smallCabinet();
            case progressive -> new mediumCabinet(); 
        };
    }

    public Display createDisplay() {
        return switch (type) {
            case straight -> new Reels();
            case bonus -> new CRT();
            case progressive -> new LCD();
        };
    }

    public Payment createPayment() {
        return new Ticket();
    }

    public GPU createGPU() {
        return switch (type) {
            case straight -> new ARM();
            case bonus -> new X86();
            case progressive -> new X77();
        };
    }

    public OS createOS() {
        return switch (type) {
            case straight, bonus -> new Linux();
            case progressive -> new Android();
        };
    }
}
