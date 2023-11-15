package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventBadgeTest {

    private static List<Arguments> badgeTestData() {
        return List.of(
                Arguments.of(21000, List.of(EventBadge.SANTA)),
                Arguments.of(15000, List.of(EventBadge.TREE)),
                Arguments.of(7000, List.of(EventBadge.STAR)),
                Arguments.of(3000, List.of())
        );
    }

    @DisplayName("각 상황별 배지 부여 Test")
    @ParameterizedTest
    @MethodSource("badgeTestData")
    void testDetermineBadges(int totalBenefit, List<EventBadge> expectedBadges) {
        List<EventBadge> actualBadges = EventBadge.determineBadges(totalBenefit);
        assertEquals(expectedBadges, actualBadges);
    }

    @Test
    @DisplayName("배지 get테스트")
    void testGetBadges() {
        Assertions.assertEquals("산타", EventBadge.SANTA.getName());
    }
}
