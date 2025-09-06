package SingletonFactory1;

public class BarProducer extends Thread {
	Factory wonka;
	public int count=0; // each producer creates 50 bars
	public int id;
	private String barType;
	
	public BarProducer(int identifier, String barType) {
        id = identifier;
        this.barType = barType;
        System.out.println("Creating new Bar Producer with ID: " + id + " for type: " + barType);
    }
	  
	public void run()                       
       {     	
		while (count<50) {
			try {
				sleep(100);
			} catch (InterruptedException e) {}
			count++;
			//System.out.println(id+":running");
			ChocolateFactory.getInstance().create(id, barType);
		}
      }
}