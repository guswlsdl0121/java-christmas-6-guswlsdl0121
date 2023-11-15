package christmas.common.constant.view;

public enum InputConstant {
    ITEM_SEPARATOR(","),
    QUANTITY_SEPARATOR("-"),
    WHITESPACE(" "),
    COLON(":"),
    WHITE_SPACE_FORMAT("\\s+");

    private final String value;

    InputConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
