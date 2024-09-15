import java.util.UUID;

abstract class user {
        protected int id;
        protected String name;
        protected String location;
        protected double rating;
        protected NotificationService notificationService;

        public user(int id, String name, String location, double rating, NotificationService notificationService) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.rating = rating;
            this.notificationService = notificationService;
        }

        public abstract void receiveNotification(String message);
    }


