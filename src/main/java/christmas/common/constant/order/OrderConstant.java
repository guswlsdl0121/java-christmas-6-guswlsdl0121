package christmas.common.constant.order;

public enum OrderConstant {
    MAX_ORDER_QUANTITY(20),
    MIN_ORDER_AMOUNT(10000);

    private final int value;

    OrderConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
