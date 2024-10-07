public class Sugar extends BaseCondiment {
    public Sugar(BaseBeverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.25;
    }

    @Override
    protected String getCondimentName() {
        return "Sugar";
    }
}