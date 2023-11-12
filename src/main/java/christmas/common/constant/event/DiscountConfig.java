package christmas.common.constant.event;

public enum DiscountConfig {
    DISCOUNT_START_AMOUNT(1000),
    DISCOUNT_INCREMENT(100),
    DISCOUNT_PER_ITEM(2023),
    SPECIAL_DISCOUNT_AMOUNT(1000);

    private final int value;

    DiscountConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

