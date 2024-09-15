class NotificationService {
    public void sendNotification(Rider rider, String event) {
        System.out.println("Notification sent to " + rider.getName() + ": " + event);
    }
}