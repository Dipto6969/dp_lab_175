import java.util.List;

interface NotificationAdapter {
    List<String> fetchNotifications();
    void markAsRead(String notificationId);
    void deleteNotification(String notificationId);
}
