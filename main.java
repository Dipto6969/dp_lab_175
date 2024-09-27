import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Create instances
        PaymentMethod creditCard = new CreditCard();
        NotificationService notificationService = new SMSNotificationService();


        Rider rider = new Rider(1, "Rider", "IUT", 5.0, creditCard, notificationService);
        Trip trip = rider.requestRide("IUT", "Mirpur", RideType.CARPOOL);

        if (trip.driver != null) {

            trip.setStatus(TripStatus.COMPLETED);

            rider.rateDriver(trip.driver, 5.0);

            trip.driver.rateRider(rider, 4.5);
        }

        // Admin managing drivers
        Admin admin = new Admin("Batman");

        admin.handleDispute(trip, "Fare dispute");
    }
}
