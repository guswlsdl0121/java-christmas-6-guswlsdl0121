package christmas.common.constant.event;

public enum DiscountType {
    D_DAY_DISCOUNT("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인");

    private final String discountName;

    DiscountType(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountName() {
        return discountName;
    }
}
