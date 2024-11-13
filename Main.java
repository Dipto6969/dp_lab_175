import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create platform APIs
        TwitterAPI twitterAPI = new TwitterAPI();
        FacebookAPI facebookAPI = new FacebookAPI();

        //Create adapters for each platform
        NotificationAdapter twitterAdapter = new TwitterAdapter(twitterAPI);
        NotificationAdapter facebookAdapter = new FacebookAdapter(facebookAPI);

        //Create the facade and register adapters
        NotificationAggregator aggregator = new NotificationAggregator();
        aggregator.addPlatform("Twitter", twitterAdapter);
        aggregator.addPlatform("Facebook", facebookAdapter);

        //Fetch and display all notifications
        List<String> notifications = aggregator.getAllNotifications();
        System.out.println("All Notifications: " + notifications);

        //Mark a Twitter notification as read
        aggregator.markNotificationAsRead("Twitter", "1");

        //Delete a Facebook notification
        aggregator.deleteNotification("Facebook", "2");

        //Handle unknown platform
        aggregator.markNotificationAsRead("UnknownPlatform", "3");
    }
}
