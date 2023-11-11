package christmas.config;

import christmas.domain.menu.Menu;

public enum EventReward {
    CHAMPAGNE_REWARD(Menu.CHAMPAGNE, 120000);

    private final Menu rewardMenu;
    private final int rewardThreshold;

    EventReward(Menu rewardMenu, int rewardThreshold) {
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
