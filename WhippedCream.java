class WhippedCream extends BaseCondiment {
    public WhippedCream(BaseBeverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.75;
    }

    @Override
    protected String getCondimentName() {
        return "Whipped Cream";
    }
}