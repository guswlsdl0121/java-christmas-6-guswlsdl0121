package christmas.constant.event;

public enum EventDate {
    YEAR(2023),
    MONTH(12),
    CHRISTMAS_DATE(25);

    private final int value;

    EventDate(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
