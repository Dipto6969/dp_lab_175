import java.util.List;

class TwitterAdapter implements NotificationAdapter {
    private TwitterAPI twitterAPI;

    public TwitterAdapter(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public List<String> fetchNotifications() {
        return twitterAPI.getNotifications();
    }

    @Override
    public void markAsRead(String notificationId) {
        twitterAPI.markAsRead(notificationId);
    }

    @Override
    public void deleteNotification(String notificationId) {
        twitterAPI.deleteNotification(notificationId);
    }
}
