import java.util.Scanner;

public class Rider extends user {
    private PaymentMethod preferredPaymentMethod;
    Scanner scanner = new Scanner(System.in);


    public Rider(int id, String name, String location, double rating, PaymentMethod preferredPaymentMethod , NotificationService notificationService) {
        super(id, name, location, rating, notificationService);

    }

    public Trip requestRide(String pickupLocation, String dropoffLocation, RideType rideType) {
        Trip trip = new Trip(pickupLocation, dropoffLocation, rideType, this);
        trip.setpickUpLocation(pickupLocation);
        trip.setDropOffLocation(dropoffLocation);
        trip.assignDriver();
        return trip;
    }

    public void rateDriver(Driver driver, double rating) {
        driver.setRating((driver.getRating() + rating) / 2);
        System.out.println(name + " rated Driver " + driver.getName() + ": " + rating);
    }

    public String getName() {
        return name;
    }

    public void setPreferredPaymentMethod(PaymentMethod preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    void makePayment(double amount) {
        preferredPaymentMethod.processPayment(amount);
    }

    @Override
    public void receiveNotification(String message) {
        notificationService.sendNotification(this, message);
    }

    public void changePaymentMethod() {
        System.out.println("Enter 1 for Credit Card, 2 for Cash");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                setPreferredPaymentMethod(new CreditCard());
                System.out.println("Payment method is credit card now");
                break;
            case 2:
                setPreferredPaymentMethod(new Cash());
                System.out.println("Payment method is cash now");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}