import java.util.UUID;

class Driver {
    private String id;
    private String name;
    private RideType vehicleType;
    private String location;
    private double rating;
    private boolean availability;

    public Driver(String name, RideType vehicleType, String location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.vehicleType = vehicleType;
        this.location = location;
        this.rating = 5.0; // default rating
        this.availability = true; // default to available
    }

    public boolean acceptRide(Trip trip) {
        if (availability && this.vehicleType == trip.getRideType()) {
            trip.assignDriver(this);
            System.out.println(name + " accepted the ride.");
            return true;
        }
        return false;
    }

    public void rateRider(Rider rider, double rating) {
        rider.rateDriver(this, rating);
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
