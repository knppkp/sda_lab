package Task2;

import java.util.Iterator;

public class Cylinder extends Prim  {
    
	private float height;
	private float radius;
	
	public Cylinder(float h, float r){
	  this.height=h;
	  this.radius=r;
	}
	
	public void render() {
		System.out.println("Cylinder:"+ height + ":" + radius);
	}

	public float volume() {
		return (float) (Math.PI*radius*radius*radius*height);
	}

	public Iterator<Object_Component> createIterator() {
		return new NullIterator();
	}

}
