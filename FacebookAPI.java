import java.util.List;

class FacebookAPI {
    public List<String> fetchAlerts() {
        return List.of("Facebook Notification 1", "Facebook Notification 2");
    }

    public void readAlert(String alertId) {
        System.out.println("Facebook: Marked notification " + alertId + " as read.");
    }

    public void removeAlert(String alertId) {
        System.out.println("Facebook: Deleted notification " + alertId);
    }
}
