package SingletonFactory1;

public class OompaLoompaBar extends Bar {
    public OompaLoompaBar(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OompaLoompaBar { ID=" + id + " }";
    }
}
