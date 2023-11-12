package christmas.common.strategy.reward;

import christmas.common.constant.event.RewardConfig;
import christmas.domain.menu.Menu;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.util.Optional;

public class ChampagneRewardStrategy implements RewardStrategy {

    @Override
    public Optional<OrderItem> determineReword(TotalAmount totalAmount) {
        return Optional.of(totalAmount)
                .filter(this::isEligibleForReward)
                .map(this::createRewardItem);
    }

    private boolean isEligibleForReward(TotalAmount amount) {
        int rewardThreshold = RewardConfig.CHAMPAGNE_REWARD.getRewardThreshold();
        return amount.isEqualOrGreater(rewardThreshold);
    }

    private OrderItem createRewardItem(TotalAmount amount) {
        int rewardThreshold = RewardConfig.CHAMPAGNE_REWARD.getRewardThreshold();
        Menu rewardMenu = RewardConfig.CHAMPAGNE_REWARD.getRewardMenu();

        int champagneCount = amount.divideBy(rewardThreshold);

        return new OrderItem(rewardMenu, new MenuQuantity(champagneCount));
    }
}



