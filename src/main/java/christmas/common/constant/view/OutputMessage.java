package christmas.common.constant.view;

public enum OutputMessage {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ASK_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ASK_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_PREVIEW("12월 [DATE]일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_HEADER("<주문 메뉴>"),
    TOTAL_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    BONUS_ITEM_HEADER("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    TOTAL_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    WON_UNIT("원"),
    ITEM_UNIT("개");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithDate(int date) {
        return this.message.replace("[DATE]", String.valueOf(date));
    }
}
