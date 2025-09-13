package Task2;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Object_Component> {

    private Stack<Iterator<Object_Component>> stack = new Stack<>();

    public CompositeIterator(Iterator<Object_Component> iterator) {
        if (iterator != null) {
            stack.push(iterator);
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<Object_Component> iterator = stack.peek();
            if (iterator.hasNext()) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    @Override
    public Object_Component next() {
        if (!hasNext()) {
            return null;
        }

        Iterator<Object_Component> iterator = stack.peek();
        Object_Component component = iterator.next();

        // Push child iterator for composite objects
        Iterator<Object_Component> childIterator = component.createIterator();
        if (childIterator != null && childIterator.hasNext()) {
            stack.push(childIterator);
            // Since this is a composite, recurse to get the next leaf
            return next();
        }

        // This is a leaf object, return it
        return component;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
