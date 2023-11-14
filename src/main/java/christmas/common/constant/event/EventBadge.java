package christmas.common.constant.event;

import java.util.ArrayList;
import java.util.List;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int amount;

    EventBadge(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static List<EventBadge> determineBadges(int totalBenefit) {
        List<EventBadge> badges = new ArrayList<>();

        if (totalBenefit >= SANTA.amount) {
            return assignSantaBadges(totalBenefit);
        }

        if (totalBenefit >= TREE.amount) {
            return assignTreeBadge();
        }

        if (totalBenefit >= STAR.amount) {
            return assignStarBadge();
        }

        return badges;
    }

    private static List<EventBadge> assignSantaBadges(int totalBenefit) {
        List<EventBadge> badges = new ArrayList<>();
        int santaCount = totalBenefit / SANTA.amount;
        for (int i = 0; i < santaCount; i++) {
            badges.add(SANTA);
        }
        return badges;
    }

    private static List<EventBadge> assignTreeBadge() {
        List<EventBadge> badges = new ArrayList<>();
        badges.add(TREE);
        return badges;
    }

    private static List<EventBadge> assignStarBadge() {
        List<EventBadge> badges = new ArrayList<>();
        badges.add(STAR);
        return badges;
    }

    public String getName() {
        return this.name;
    }
}
