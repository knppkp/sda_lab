public class FanHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (AIDetector.isFan(request)) {
            System.out.println("Fan email Handled");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
