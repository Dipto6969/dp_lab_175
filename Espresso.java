public class Espresso extends BaseBeverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 3.00;
    }
}