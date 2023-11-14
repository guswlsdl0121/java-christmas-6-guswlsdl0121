package christmas.controller;

import christmas.common.strategy.reward.RewardStrategy;
import christmas.view.output.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.Optional;

public class RewardController {
    private final RewardStrategy rewardStrategy;

    public RewardController(RewardStrategy rewardStrategy) {
        this.rewardStrategy = rewardStrategy;
    }

    public Optional<OrderItem> applyReward(TotalAmount totalAmount) {
        return rewardStrategy.determineReword(totalAmount);
    }
}
