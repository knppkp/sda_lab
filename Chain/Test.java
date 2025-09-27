public class Test {
    public static void main(String[] args) {
        String email1 = "complaint";
        String email2 = "new location";
        String email3 = "business";
        String email4 = "fan";
        String email5 = "spam";

        Handler spamHandler = new SpamHandler();
        Handler fanHandler = new FanHandler();
        Handler complaintHandler = new ComplaintHandler();
        Handler newLocationHandler = new NewLocationHandler();

        spamHandler.setSuccessor(fanHandler);
        fanHandler.setSuccessor(complaintHandler);
        complaintHandler.setSuccessor(newLocationHandler);

        System.out.println("Testing Email 1: ");
        spamHandler.handleRequest(email1);

        System.out.println("\nTesting Email 2: ");
        spamHandler.handleRequest(email2);

        System.out.println("\nTesting Email 3: ");
        spamHandler.handleRequest(email3);

        System.out.println("\nTesting Email 4: ");
        spamHandler.handleRequest(email4);

        System.out.println("\nTesting Email 5: ");
        spamHandler.handleRequest(email5);
    }
}
