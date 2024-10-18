public class EPostalMailAdapter implements Notification {
    private EPostalMail ePostalMail;
    private String recipientName;
    private String recipientAddress;


    public EPostalMailAdapter(EPostalMail ePostalMail, String recipientName, String recipientAddress) {
        this.ePostalMail = ePostalMail;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
    }

    @Override
    public void send(String recipient, String message) {
        ePostalMail.sendMail(recipientName, recipientAddress, message);
    }
}
