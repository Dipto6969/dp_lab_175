import java.util.Scanner;

class Trip {
    private static int tripCounter = 0;
    private int id;
    private String pickupLocation;
    private String dropoffLocation;
    private RideType rideType;
    public Rider rider;
    public Driver driver;
    private TripStatus status;
    private double fare;
    private double distance;
    private NotificationService notificationService;

    public Trip(String pickupLocation, String dropoffLocation, RideType rideType, Rider rider) {
        this.id = ++tripCounter;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.rideType = rideType;
        this.rider = rider;
        this.status = TripStatus.REQUESTED;
        this.fare = calculateFare();
        this.distance = calculateDistance();
        rider.receiveNotification("Trip requested");
    }

    public RideType getRideType() {
        return rideType;
    }

    public void assignDriver() {
        Driver driver = FindDriver.findAvailableDriver(rideType, pickupLocation);
        if (driver != null) {
            this.driver = driver;
            driver.setAvailability(false);
            driver.acceptRide(this);
            rider.receiveNotification("Driver found: " + driver.name);
            driver.receiveNotification("Ride assigned to you.");
        } else {
            rider.receiveNotification("No drivers available.");
            setStatus(TripStatus.CANCELLED);
        }
    }

    public void setStatus(TripStatus status) {
        this.status = status;
        if (status == TripStatus.COMPLETED) {
            completeTrip();
        }
    }

    public double calculateFare() {
        return rideType.getBaseFare() + (rideType.getPricePerKm() * distance);
    }

    private double calculateDistance() {
        return 10.0;//default distance
    }

    public void completeTrip() {
        rider.receiveNotification("Trip completed");
        driver.receiveNotification("Trip completed");
        System.out.println(
                "Default payment method is " + rider.getPreferredPaymentMethod().getClass().getSimpleName());
        System.out.println("Do you want to change your payment method? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equals("yes")) {
            rider.changePaymentMethod();
        }

        rider.makePayment(fare);

        driver.setAvailability(true);
    }


    private void processPayment() {
        PaymentMethod paymentMethod = rider.getPreferredPaymentMethod();
        if (paymentMethod != null) {
            paymentMethod.processPayment(fare);
        }
    }
    public void getpickUpLocation() {
        System.out.println("Pickup location: " + pickupLocation);
    }

    public void getDropOffLocation() {
        System.out.println("Drop off location: " + dropoffLocation);
    }

    public void setpickUpLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropoffLocation = dropOffLocation;
    }
}