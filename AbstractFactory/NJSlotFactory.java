package AbstractFactory;

public class NJSlotFactory extends SlotFactory {

	protected Slot makeSlot(String item) {
		Slot slot=null;
		if (item.equals("straight")) {
			SlotComponentFactory componentFactory = new NJSlotComponentFactory(SlotType.straight);
			slot=new StraightSlot(componentFactory);
			slot.setName("New Jersey Style Straight Slot");
		}
		else if (item.equals("bonus")) {
			SlotComponentFactory componentFactory = new NJSlotComponentFactory(SlotType.bonus);
			slot=new BonusSlot(componentFactory);
			slot.setName("New Jersey Style Bonus Slot");
		}
		else if (item.equals("progressive")) {
			SlotComponentFactory componentFactory = new NJSlotComponentFactory(SlotType.progressive);
			slot=new ProgressiveSlot(componentFactory);
			slot.setName("New Jersey Style Progressive Slot");
		}
		return slot;
	}
}