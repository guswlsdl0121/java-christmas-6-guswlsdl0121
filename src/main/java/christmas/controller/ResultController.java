package christmas.controller;

import christmas.domain.DiscountResult;
import christmas.vo.discount.Discount;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.List;
import java.util.Optional;

public class ResultController {
    public DiscountResult createDiscountResult(List<Discount> discounts) {
        return new DiscountResult(discounts);
    }

    public int getTotalBenefitAmount(DiscountResult discountResult, Optional<OrderItem> reward) {
        return discountResult.calculateTotalBenefit(reward);
    }

    public int getDiscountedTotalAmount(DiscountResult discountResult, TotalAmount totalAmount) {
        return discountResult.calculateDiscountedTotal(totalAmount);
    }
}
