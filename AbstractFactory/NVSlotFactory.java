package AbstractFactory;

public class NVSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		if (item.equals("straight")) {
			SlotComponentFactory componentFactory = new NVSlotComponentFactory(SlotType.straight);
			slot=new StraightSlot(componentFactory);
			slot.setName("Nevada Style Straight Slot");
		}
		else if (item.equals("bonus")) {
			SlotComponentFactory componentFactory = new NVSlotComponentFactory(SlotType.bonus);
			slot=new BonusSlot(componentFactory);
			slot.setName("Nevada Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			SlotComponentFactory componentFactory = new NVSlotComponentFactory(SlotType.progressive);
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("Nevada Style Progressive Slot");
		}
		return slot;
	}
}