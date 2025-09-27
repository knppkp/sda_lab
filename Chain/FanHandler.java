public class FanHandler extends Handler {
    public void handleRequest(String request) {
        if (AIDetector.isFan(request)) {
            System.out.println("Fan email Handled");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
            return;
        }
        System.out.println(request + " Email unhandled");
    }
}
