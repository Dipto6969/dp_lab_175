import java.util.UUID;

public class main {
    public static void main(String[] args) {
        // Create instances
        PaymentMethod creditCard = new CreditCard();
        Rider rider = new Rider("Mohtasim Dipto", "IUT", creditCard);
        Driver driver = new Driver("Messi", RideType.CARPOOL, "Mirpur");

        // Request and accept a ride
        Trip trip = rider.requestRide("IUT", "Mirpur", RideType.CARPOOL);
        driver.acceptRide(trip);

        // Complete the trip
        trip.completeTrip();

        // Riders and drivers rate each other
        rider.rateDriver(driver, 5.0);
        driver.rateRider(rider, 4.0);

        // Admin managing drivers
        Admin admin = new Admin("Batman");
        admin.manageDriver(driver, "deactivate");
        admin.handleDispute(trip, "Fare dispute");
    }
}
