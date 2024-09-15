import java.util.UUID;

class Rider {
    private String id;
    private String name;
    private String location;
    private double rating;
    private PaymentMethod preferredPaymentMethod;

    public Rider(String name, String location, PaymentMethod preferredPaymentMethod) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.rating = 5.0; // default rating
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public Trip requestRide(String pickupLocation, String dropoffLocation, RideType rideType) {
        System.out.println(name + " requested a " + rideType + " ride from " + pickupLocation + " to " + dropoffLocation);
        return new Trip(pickupLocation, dropoffLocation, rideType, this);
    }

    public void rateDriver(Driver driver, double rating) {
        driver.setRating((driver.getRating() + rating) / 2);
        System.out.println(name + " rated Driver " + driver.getName() + ": " + rating);
    }

    public String getName() {
        return name;
    }

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }
}