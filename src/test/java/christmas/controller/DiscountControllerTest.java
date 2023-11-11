package christmas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;
import christmas.factory.DiscountStrategyFactory;
import christmas.vo.discount.Discount;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountControllerTest {

    private DiscountController discountController;

    @BeforeEach
    void setUp() {
        discountController = new DiscountController(new DiscountStrategyFactory(LocalDate.of(2023, 12, 3)));
    }

    @Test
    void testProceedDiscountWithMultipleDiscounts() {
        Orders orders = Orders.create();
        orders.addMenu(new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1))); // 메인
        orders.addMenu(new OrderItem(Menu.BBQ_RIBS, new MenuQuantity(1))); // 메인
        orders.addMenu(new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(2))); // 디저트
        orders.addMenu(new OrderItem(Menu.ZERO_COLA, new MenuQuantity(1)));

        List<Discount> totalDiscount = discountController.proceedDiscount(orders, LocalDate.of(2023, 12, 3));

        int expectedDiscountAmount = 6246;

        int totalDiscountAmount = totalDiscount.stream()
                .mapToInt(discount -> discount.discountAmount().amount())
                .sum();

        assertEquals(expectedDiscountAmount, totalDiscountAmount);
    }
}