package christmas.common.constant.error;

import christmas.common.constant.view.MessageConstant;

public enum ErrorMessage {
    IS_BLANK("입력값이 비어있습니다."),
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    BEVERAGES_ONLY_ORDER("음료만 주문하실 수는 없습니다. 다시 입력해 주세요."),
    ORDER_QUANTITY_EXCEEDED("메뉴는 한번에 최대 20개까지만 주문할 수 있습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MessageConstant.ERROR_PREFIX.getValue() + this.message + MessageConstant.LINE_SEPARATOR.getValue();
    }
}
