package SingletonFactory1;

public class WonkaBar extends Bar {

	public WonkaBar(int identifier) {
			id = identifier;
	}	

	@Override
    public String toString() {
        return "WonkaBar { ID=" + id + " }";
    }
}
