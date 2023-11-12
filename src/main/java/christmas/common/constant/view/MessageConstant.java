package christmas.common.constant.view;

public enum MessageConstant {
    LINE_SEPARATOR(System.lineSeparator()),
    ERROR_PREFIX("[ERROR] ");
    private final String value;

    MessageConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
