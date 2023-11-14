package christmas.common.constant.event;

import christmas.domain.Menu;

public enum RewardConfig {
    CHAMPAGNE_REWARD(Menu.CHAMPAGNE, 120000);

    private final Menu rewardMenu;
    private final int rewardThreshold;

    RewardConfig(Menu rewardMenu, int rewardThreshold) {
        this.rewardMenu = rewardMenu;
        this.rewardThreshold = rewardThreshold;
    }

    public Menu getRewardMenu() {
        return rewardMenu;
    }

    public int getRewardThreshold() {
        return rewardThreshold;
    }
}
