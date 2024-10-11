public class SimpleProduct implements Product {
    private String name;
    private String description;
    private double price;

    public SimpleProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product: " + name + ", Description: " + description + ", Price: $" + price);
    }
}