import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NotificationAggregator {
    private Map<String, NotificationAdapter> platformAdapters;

    public NotificationAggregator() {
        this.platformAdapters = new HashMap<>();
    }

    // Register a platform with its adapter
    public void addPlatform(String platformName, NotificationAdapter adapter) {
        platformAdapters.put(platformName.toLowerCase(), adapter);
    }

    // Fetch notifications from all platforms
    public List<String> getAllNotifications() {
        List<String> allNotifications = new ArrayList<>();
        for (NotificationAdapter adapter : platformAdapters.values()) {
            allNotifications.addAll(adapter.fetchNotifications());
        }
        return allNotifications;
    }

    // Mark a notification as read on a specific platform
    public void markNotificationAsRead(String platform, String notificationId) {
        NotificationAdapter adapter = platformAdapters.get(platform.toLowerCase());
        if (adapter != null) {
            adapter.markAsRead(notificationId);
        } else {
            System.out.println("Platform '" + platform + "' not found.");
        }
    }

    // Delete a notification on a specific platform
    public void deleteNotification(String platform, String notificationId) {
        NotificationAdapter adapter = platformAdapters.get(platform.toLowerCase());
        if (adapter != null) {
            adapter.deleteNotification(notificationId);
        } else {
            System.out.println("Platform '" + platform + "' not found.");
        }
    }
}
