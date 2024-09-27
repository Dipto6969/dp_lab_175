public class FindDriver {
    public static Driver findAvailableDriver(RideType rideType, String pickupLocation) {
        return new Driver(1, "Driver", pickupLocation, 4.5, new SMSNotificationService());
    }

}