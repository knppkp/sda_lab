public class AIDetector {
    public static boolean isSpam(String email){
        return email.equals("spam");
    }
    public static boolean isFan(String email){
        return email.equals("fan");
    }
    public static boolean isComplaint(String email){
        return email.equals("complaint");
    }
    public static boolean isNewLocation(String email){
        return email.equals("new location");
    }
}
