import java.util.UUID;

public class Driver extends user {
    private String id;
    public String name;
    private String vehicleType;
    private String location;
    private double rating;
    private boolean availability;

    public Driver(int id, String name, String location, double rating, NotificationService notificationService) {
        super(id, name, location, rating, notificationService);
        this.vehicleType = vehicleType;
        this.availability = true;
    }

    @Override
    public void receiveNotification(String message) {
        notificationService.sendNotification(this, message);
    }


    public void acceptRide(Trip trip) {
        trip.setStatus(TripStatus.ACCEPTED);
        receiveNotification("You have accepted a new ride.");
    }

    public void updateLocation(String newLocation) {

        this.location = newLocation;

    }

    public void startTrip(Trip trip) {
        trip.setStatus(TripStatus.ONGOING);
        receiveNotification("Trip started.");
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

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
