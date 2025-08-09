package AbstractFactory;

public class StraightSlot extends Slot {
	SlotComponentFactory componentFactory;
	
	public StraightSlot(SlotComponentFactory componentFactory) {
		this.componentFactory= componentFactory;
	}
 
	void build() {
		System.out.println("Building " + name);
		cabinet = componentFactory.createCabinet();
		display = componentFactory.createDisplay();
		payment = componentFactory.createPayment();
        gpu = componentFactory.createGPU();
        os = componentFactory.createOS();
	}
}
