import java.util.ArrayList;
import java.util.List;


class Bundle implements Product {
    private String name;
    private String description;
    private List<Product> products = new ArrayList<>();

    public Bundle(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
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
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total; // The total price is calculated by summing the prices of its components
    }



    @Override
    public void displayDetails() {
        System.out.println("Bundle: " + name + ", Description: " + description + ", Total Price: $" + getPrice());
        for (Product product : products) {
            product.displayDetails();
        }
    }
}
