public class Milk extends BaseCondiment {
    public Milk(BaseBeverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }

    @Override
    protected String getCondimentName() {
        return "Milk";
    }
}