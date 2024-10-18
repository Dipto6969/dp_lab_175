public class SMSNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }
}
