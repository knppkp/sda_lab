package Task2;

import java.util.Iterator;

public class NullIterator implements Iterator<Object_Component> {

	public boolean hasNext() {
		return false;
	}

	public Object_Component next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
