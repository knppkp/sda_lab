public class NewLocationHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (AIDetector.isNewLocation(request)) {
            System.out.println("New location email Handled");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
            return;
        }
        System.out.println(request + " Email unhandled");
    }
}
