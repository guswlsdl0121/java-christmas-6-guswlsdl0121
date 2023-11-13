package christmas.controller;

import christmas.common.strategy.reward.RewardStrategy;
import christmas.view.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.Optional;

public class RewardController {
    private final RewardStrategy rewardStrategy;

    public RewardController(RewardStrategy rewardStrategy) {
        this.rewardStrategy = rewardStrategy;
    }

    public Optional<OrderItem> determineReward(TotalAmount totalAmount) {
        Optional<OrderItem> reward = rewardStrategy.determineReword(totalAmount);
        reward.ifPresentOrElse(
                OutputView::printRewardItem,
                OutputView::printNoReward
        );
        return reward;
    }
}
