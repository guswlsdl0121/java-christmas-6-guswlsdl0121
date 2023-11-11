package christmas.constant.event;

public enum DateConfig {
    YEAR(2023),
    MONTH(12),
    CHRISTMAS_DATE(25);

    private final int value;

    DateConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
