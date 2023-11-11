package christmas.common.strategy;

import christmas.vo.OrderItem;
import christmas.vo.TotalAmount;
import java.util.Optional;

public interface RewardStrategy {
    Optional<OrderItem> determineReword(TotalAmount totalAmount);
}
