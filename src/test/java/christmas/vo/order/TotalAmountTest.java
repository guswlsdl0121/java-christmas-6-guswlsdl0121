package christmas.vo.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TotalAmountTest {

    @Test
    void testIsEqualOrGreater() {
        TotalAmount totalAmount = new TotalAmount(1000);
        assertTrue(totalAmount.isEqualOrGreater(500));
        assertFalse(totalAmount.isEqualOrGreater(1500));
    }

    @Test
    void testDivideBy() {
        TotalAmount totalAmount = new TotalAmount(1000);
        assertEquals(500, totalAmount.divideBy(2));
        assertEquals(250, totalAmount.divideBy(4));
    }

    @Test
    void testCalculateDiscountedAmount() {
        TotalAmount totalAmount = new TotalAmount(1000);
        assertEquals(800, totalAmount.calculateDiscountedAmount(200));
        assertEquals(500, totalAmount.calculateDiscountedAmount(500));
    }
}
