package christmas.strategy.reward;

import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.Optional;

public interface RewardStrategy {
    /**
     * 보상 전략을 정의하는 인터페이스.
     * 주문 총액에 따라 특정한 보상을 결정하는 로직을 포함한다.
     *
     * @param totalAmount 할인이 적용되기 전의 주문 총액
     * @return 보상이 존재하는 경우 해당 보상의 OrderItem을 포함하는 Optional 객체,
     *         보상이 없는 경우 빈 Optional 객체
     */
    Optional<OrderItem> determineReword(TotalAmount totalAmount);
}
