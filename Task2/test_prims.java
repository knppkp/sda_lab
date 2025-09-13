package Task2;

import java.util.Iterator;

public class test_prims {

	public static void main(String[] args) {
        Cube cube1 = new Cube(1.0f,1.0f,1.0f);
        Cube cube2 = new Cube(1.0f,1.0f,1.0f);
        Sphere sphere1 = new Sphere(4.0f);
        Cylinder cylinder1 = new Cylinder(2.0f, 1.0f);
        
        //Initialize three composite prims
        Object pcom1 = new Object();
        Object pcom2 = new Object();
          
         pcom1.add(cube1);
         pcom1.add(cube2);
         pcom1.add(cylinder1);
  
         pcom2.add(pcom1);
         pcom2.add(sphere1);

     
         pcom2.render();
         System.out.println(pcom2.volume());
        
         Iterator<Object_Component> iterator = pcom2.createIterator();
         while (iterator.hasNext()) {
         	(iterator.next()).render();
           }
        }
}

 