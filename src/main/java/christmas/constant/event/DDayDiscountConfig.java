package christmas.constant.event;

public enum DDayDiscountConfig {
    DISCOUNT_START_AMOUNT(1000),
    DISCOUNT_INCREMENT(100);

    private final int value;

    DDayDiscountConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
