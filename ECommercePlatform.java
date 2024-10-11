public class ECommercePlatform {
    public static void main(String[] args) {
        // Create simple products
        Product laptop = new SimpleProduct("Asus", "Gaming Laptop", 1200);
        Product phone = new SimpleProduct("Samsung", "Smartphone", 800);
        Product tablet = new SimpleProduct("Apple", "Tablet", 1000);

        // Create a bundle
        Bundle holidayGiftBasket = new Bundle("Holiday Gift Basket", "A delightful gift basket with goodies");

        // Add products to the bundle
        holidayGiftBasket.addProduct(laptop);
        holidayGiftBasket.addProduct(phone);

        // Create another bundle
        Bundle electronicsBundle = new Bundle("Electronics Bundle", "A bundle of electronics");
        electronicsBundle.addProduct(laptop);
        electronicsBundle.addProduct(holidayGiftBasket);

        // Display details and calculate total price
        System.out.println("Displaying Product Information and Total Price:");
        electronicsBundle.displayDetails();
        holidayGiftBasket.displayDetails();
        tablet.displayDetails();
    }
}