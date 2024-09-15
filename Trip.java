import java.util.UUID;

class Trip {
    private String id;
    private String pickupLocation;
    private String dropoffLocation;
    private RideType rideType;
    private Rider rider;
    private Driver driver;
    private TripStatus status;
    private double fare;

    public Trip(String pickupLocation, String dropoffLocation, RideType rideType, Rider rider) {
        this.id = UUID.randomUUID().toString();
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.rideType = rideType;
        this.rider = rider;
        this.status = TripStatus.REQUESTED;
        this.fare = calculateFare();
    }

    public RideType getRideType() {
        return rideType;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.status = TripStatus.ONGOING;
        notifyEvent("Driver assigned");
    }

    private double calculateFare() {
        double baseFare = 10.0;
        switch (rideType) {
            case LUXURY:
                return baseFare * 3;
            case BIKE:
                return baseFare * 0.5;
            default:
                return baseFare;
        }
    }

    public void completeTrip() {
        this.status = TripStatus.COMPLETED;
        notifyEvent("Trip completed");
        processPayment();
    }

    private void notifyEvent(String event) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(rider, event);
    }

    private void processPayment() {
        PaymentMethod paymentMethod = rider.getPreferredPaymentMethod();
        if (paymentMethod != null) {
            paymentMethod.processPayment(fare);
        }
    }
}