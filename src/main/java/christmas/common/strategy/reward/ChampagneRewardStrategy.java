package christmas.common.strategy.reward;

import christmas.config.EventReward;
import christmas.domain.menu.Menu;
import christmas.vo.MenuQuantity;
import christmas.vo.OrderItem;
import christmas.vo.TotalAmount;
import java.util.Optional;

public class ChampagneRewardStrategy implements RewardStrategy {

    @Override
    public Optional<OrderItem> determineReword(TotalAmount totalAmount) {
        return Optional.of(totalAmount)
                .filter(this::isEligibleForReward)
                .map(this::createRewardItem);
    }

    private boolean isEligibleForReward(TotalAmount amount) {
        int rewardThreshold = EventReward.CHAMPAGNE_REWARD.getRewardThreshold();
        return amount.isEqualOrGreater(rewardThreshold);
    }

    private OrderItem createRewardItem(TotalAmount amount) {
        int rewardThreshold = EventReward.CHAMPAGNE_REWARD.getRewardThreshold();
        Menu rewardMenu = EventReward.CHAMPAGNE_REWARD.getRewardMenu();

        int champagneCount = amount.divideBy(rewardThreshold);

        return new OrderItem (rewardMenu, new MenuQuantity(champagneCount));
    }
}



