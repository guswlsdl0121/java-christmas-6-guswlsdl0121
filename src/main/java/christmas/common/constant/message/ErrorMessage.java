package christmas.common.constant.message;

public enum ErrorMessage {
    IS_BLANK("입력값이 비어있습니다."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MessageConstant.ERROR_PREFIX.getValue() + this.message + MessageConstant.LINE_SEPARATOR.getValue();
    }
}
