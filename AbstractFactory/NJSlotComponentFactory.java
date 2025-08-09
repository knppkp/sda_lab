package AbstractFactory;

public class NJSlotComponentFactory implements SlotComponentFactory {

	private final SlotType type;

    public NJSlotComponentFactory(SlotType type) {
        this.type = type;
    }

    public Cabinet createCabinet() {
        return switch (type) {
            case straight, progressive -> new smallCabinet();
            case bonus -> new largeCabinet();
        };
    }

    public Display createDisplay() {
        return switch (type) {
            case straight -> new LCD();
            case bonus -> new Reels();
            case progressive -> new CRT();
        };
    }

    public Payment createPayment() {
		return switch (type) {
            case straight, bonus -> new Coins();
            case progressive -> new Bills();
        };
    }

	public GPU createGPU() {
        return switch (type) {
            case straight, bonus -> new ARM();
            case progressive -> new X86();
        };
    }

    public OS createOS() {
        return switch (type) {
            case straight, bonus -> new WindowME();
            case progressive -> new WindowXP();
        };
    }
}
