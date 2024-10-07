public abstract class BaseCondiment extends BaseBeverage {
    protected BaseBeverage beverage;

    public BaseCondiment(BaseBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + getCondimentName();
    }

    protected abstract String getCondimentName();
}