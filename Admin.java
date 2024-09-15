import java.util.UUID;

class Admin {
    private String id;
    private String name;

    public Admin(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void manageDriver(Driver driver, String action) {
        if (action.equals("deactivate")) {
            driver.setRating(0);
            System.out.println("Admin " + name + " deactivated Driver " + driver.getName());
        } else if (action.equals("activate")) {
            System.out.println("Admin " + name + " activated Driver " + driver.getName());
        }
    }

    public void handleDispute(Trip trip, String reason) {
        System.out.println("Admin " + name + " is handling dispute for Trip ID " + trip + " due to: " + reason);
    }
}