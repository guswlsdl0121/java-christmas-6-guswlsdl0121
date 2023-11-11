package christmas.strategy.discount;

import christmas.domain.order.Orders;
import christmas.vo.discount.Discount;
import java.time.LocalDate;
import java.util.Optional;

public interface DiscountStrategy {
    /**
     * 할인 정책에 따라 주문에 적용될 할인과 할인 금액을 계산한다.
     *
     * @param orders 주문 객체
     * @param date   주문 날짜
     * @return discount 할인 타입과 할인 금액
     */
    Optional<Discount> calculateDiscount(Orders orders, LocalDate date);
}
