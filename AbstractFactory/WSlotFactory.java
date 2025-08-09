package AbstractFactory;

public class WSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		if (item.equals("straight")) {
			SlotComponentFactory componentFactory = new WSlotComponentFactory(SlotType.straight);
			slot=new StraightSlot(componentFactory);
			slot.setName("Washington Style Straight Slot");
		}
		else if (item.equals("bonus")) {
			SlotComponentFactory componentFactory = new WSlotComponentFactory(SlotType.bonus);
			slot=new BonusSlot(componentFactory);
			slot.setName("Washington Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			SlotComponentFactory componentFactory = new WSlotComponentFactory(SlotType.progressive);
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("Washington Style Progressive Slot");
		}
		return slot;
	}
}