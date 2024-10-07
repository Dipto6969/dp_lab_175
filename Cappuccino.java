public class Cappuccino extends BaseBeverage {
    public Cappuccino() {
        description = "Cappuccino";
    }

    @Override
    public double cost() {
        return 3.75;
    }
}