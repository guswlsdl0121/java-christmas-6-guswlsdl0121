package christmas.config;

import christmas.domain.strategy.reward.ChampagneRewardStrategy;
import christmas.domain.strategy.reward.RewardStrategy;

public class RewardConfig {
    public static RewardStrategy createRewardStrategy() {
        return new ChampagneRewardStrategy();
    }
}
