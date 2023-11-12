package christmas.common.constant.view;

public enum InputConstant {
    ITEM_SEPARATOR(","),
    QUANTITY_SEPARATOR("-"),
    WHITESPACE(" ");

    private final String value;

    InputConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
