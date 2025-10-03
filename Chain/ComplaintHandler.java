public class ComplaintHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (AIDetector.isComplaint(request)) {
            System.out.println("Complaint email Handled");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
