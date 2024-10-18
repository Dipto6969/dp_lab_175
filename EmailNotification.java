public class EmailNotification implements Notification{

    @Override
    public void send(String recipient, String message) {
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }
}
