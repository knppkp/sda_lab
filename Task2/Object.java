package Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Object extends Object_Component {
    private List<Object_Component> components = new ArrayList<>();

    @Override
    public void add(Object_Component component) {
        components.add(component);
    }

    @Override
    public void remove(Object_Component component) {
        components.remove(component);
    }

    @Override
    public Object_Component getChild(int i) {
        return components.get(i);
    }

    @Override
    public void render() {
        for (Object_Component component : components) {
            component.render();
        }
    }

    @Override
    public float volume() {
        float totalVolume = 0.0f;
        for (Object_Component component : components) {
            totalVolume += component.volume();
        }
        return totalVolume;
    }

    @Override
    public Iterator<Object_Component> createIterator() {
        return new CompositeIterator(components.iterator());
    }
}
