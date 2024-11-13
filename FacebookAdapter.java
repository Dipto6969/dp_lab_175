import java.util.List;

class FacebookAdapter implements NotificationAdapter {
    private FacebookAPI facebookAPI;

    public FacebookAdapter(FacebookAPI facebookAPI) {
        this.facebookAPI = facebookAPI;
    }

    @Override
    public List<String> fetchNotifications() {
        return facebookAPI.fetchAlerts();
    }

    @Override
    public void markAsRead(String notificationId) {
        facebookAPI.readAlert(notificationId);
    }

    @Override
    public void deleteNotification(String notificationId) {
        facebookAPI.removeAlert(notificationId);
    }
}
