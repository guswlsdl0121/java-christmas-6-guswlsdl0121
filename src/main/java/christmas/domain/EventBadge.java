package christmas.domain;

import java.util.Collections;
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
        if (totalBenefit >= SANTA.amount) {
            return Collections.singletonList(SANTA);
        }

        if (totalBenefit >= TREE.amount) {
            return Collections.singletonList(TREE);
        }

        if (totalBenefit >= STAR.amount) {
            return Collections.singletonList(STAR);
        }

        return Collections.emptyList();
    }

    public String getName() {
        return this.name;
    }
}
