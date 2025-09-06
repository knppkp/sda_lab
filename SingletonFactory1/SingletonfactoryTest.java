package SingletonFactory1;

public class SingletonfactoryTest {
	public static void main(String[] args) {
        BarProducer t1 = new BarProducer(1, "WonkaBar");
        BarProducer t2 = new BarProducer(2, "WonkaBar");
        BarProducer t3 = new BarProducer(3, "OompaLoompaBar");
        BarProducer t4 = new BarProducer(4, "OompaLoompaBar");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
