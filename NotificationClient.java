public class NotificationClient {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();

        EPostalMail ePostalMail = new EPostalMail();
        Notification ePostalMailAdapter = new EPostalMailAdapter(ePostalMail, "Dipto", "Mirpur, Dhaka");

        emailNotification.send("dipto@email.com", "Hello Dipto via email");
        smsNotification.send("1234567890", "Hello Dipto via sms");
        //ePostalMailAdapter.send("dipto1@gmail.com", " Hello Dipto via ePostalMail");
        ePostalMail.sendMail("Dipto", "Mirpur, Dhaka", "Hello Dipto via ePostalMail");

    }

}
