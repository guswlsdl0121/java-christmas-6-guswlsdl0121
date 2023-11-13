package christmas.config;

import christmas.common.strategy.reward.ChampagneRewardStrategy;
import christmas.common.strategy.reward.RewardStrategy;

public class RewardConfig {
    public static RewardStrategy createRewardStrategy() {
        return new ChampagneRewardStrategy();
    }
}
