package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.common.constant.event.DiscountType;
import christmas.vo.discount.Discount;
import christmas.vo.discount.DiscountAmount;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountResultTest {

    @Test
    @DisplayName("증정 상품 가격 포함 햬택 금액 계산 Test")
    void testCalculateTotalBenefitWithReward() {
        List<Discount> discounts = List.of(
                new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(1000)),
                new Discount(DiscountType.D_DAY_DISCOUNT, new DiscountAmount(500))
        );
        OrderItem reward = new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1));
        DiscountResult discountResult = new DiscountResult(discounts);

        int totalBenefit = discountResult.calculateTotalBenefit(Optional.of(reward));
        assertEquals(1000 + 500 + reward.calculateTotalPrice(), totalBenefit);
    }

    @Test
    @DisplayName("증정 삼풍 미포함 혜택 가격 테스트")
    void testCalculateTotalBenefitWithoutReward() {
        List<Discount> discounts = List.of(
                new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(1000)),
                new Discount(DiscountType.WEEKDAY_DISCOUNT, new DiscountAmount(500))
        );
        DiscountResult discountResult = new DiscountResult(discounts);

        int totalBenefit = discountResult.calculateTotalBenefit(Optional.empty());
        assertEquals(1000 + 500, totalBenefit);
    }

    @Test
    @DisplayName("할인 가격 계산")
    void testCalculateDiscountedTotal() {
        List<Discount> discounts = List.of(
                new Discount(DiscountType.SPECIAL_DISCOUNT, new DiscountAmount(1000)),
                new Discount(DiscountType.WEEKEND_DISCOUNT, new DiscountAmount(500))
        );
        TotalAmount totalAmount = new TotalAmount(20000);
        DiscountResult discountResult = new DiscountResult(discounts);

        int discountedTotal = discountResult.calculateDiscountedTotal(totalAmount);
        assertEquals(totalAmount.calculateDiscountedAmount(1000 + 500), discountedTotal);
    }
}
