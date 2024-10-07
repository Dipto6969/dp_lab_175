import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Coffee Shop!\n");

        // Define a list of available beverages
        List<BaseBeverage> beverages = new ArrayList<>();
        beverages.add(new Espresso());
        beverages.add(new Latte());
        beverages.add(new Cappuccino());

        // Display available beverages
        System.out.println("Available Beverages:");
        for (BaseBeverage beverage : beverages) {
            System.out.printf("%s: $%.2f%n", beverage.getDescription(), beverage.cost());
        }

        // Select a beverage
        BaseBeverage selectedBeverage = null;
        while (selectedBeverage == null) {
            System.out.print("Select a beverage (Espresso, Latte, Cappuccino): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "Espresso":
                    selectedBeverage = new Espresso();
                    break;
                case "Latte":
                    selectedBeverage = new Latte();
                    break;
                case "Cappuccino":
                    selectedBeverage = new Cappuccino();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        // Add condiments
        while (true) {
            System.out.print("Would you like to add a condiment? (yes/no): ");
            String addCondiment = scanner.nextLine().toLowerCase();
            if (addCondiment.equals("no")) {
                break;
            } else if (addCondiment.equals("yes")) {
                System.out.print("Select a condiment (Milk, Sugar, Whipped Cream): ");
                String condimentChoice = scanner.nextLine();
                switch (condimentChoice) {
                    case "Milk":
                        selectedBeverage = new Milk(selectedBeverage);
                        break;
                    case "Sugar":
                        selectedBeverage = new Sugar(selectedBeverage);
                        break;
                    case "Whipped Cream":
                        selectedBeverage = new WhippedCream(selectedBeverage);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }

        // Display order summary
        System.out.println("\nYour Order Summary:");
        System.out.println(selectedBeverage.getDescription());
        System.out.printf("Total Cost: $%.2f%n", selectedBeverage.cost());

        scanner.close();
    }
}
