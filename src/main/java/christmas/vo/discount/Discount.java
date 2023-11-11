package christmas.vo.discount;

import christmas.constant.event.DiscountType;

public record Discount(DiscountType discountType, DiscountAmount discountAmount) {
}
