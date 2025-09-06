package SingletonFactory1;

import java.util.HashMap;
import java.util.Map;

public class ChocolateFactory implements Factory {

    private int wonkaCounter = 0;
    private int oompaCounter = 0;

    private static ChocolateFactory uniqueInstance;

    private ChocolateFactory() {}

    public static synchronized ChocolateFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateFactory();
        }
        return uniqueInstance;
    }

    // Thread-safe creation
    @Override
    public synchronized Bar create(int producerId, String type) {
        Bar bar;
        switch (type) {
            case "WonkaBar":
                bar = new WonkaBar(++wonkaCounter);
                break;
            case "OompaLoompaBar":
                bar = new OompaLoompaBar(++oompaCounter);
                break;
            default:
                throw new IllegalArgumentException("Unknown bar type: " + type);
        }
        System.out.println("Producer " + producerId + " creates " + bar);
        return bar;
    }
}
