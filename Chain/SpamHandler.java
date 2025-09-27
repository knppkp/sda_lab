
public class SpamHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (AIDetector.isSpam(request)) {
            System.out.println("Spam email Handled");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
            return;
        }
        System.out.println(request + " Email unhandled");
    }
}
