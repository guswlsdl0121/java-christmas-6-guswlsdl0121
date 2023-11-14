package christmas.vo.discount;

import christmas.common.constant.event.DiscountType;

public record Discount(DiscountType discountType, DiscountAmount discountAmount) {
    public int calculateAmount() {
        return discountAmount().amount();
    }
}
