package christmas.vo.order;

import christmas.domain.Menu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void testCalculateTotalPrice() {
        Menu menu = Menu.T_BONE_STEAK;
        MenuQuantity quantity = new MenuQuantity(2);
        OrderItem orderItem = new OrderItem(menu, quantity);

        int totalPrice = orderItem.calculateTotalPrice();
        assertEquals(menu.calculatePrice(quantity), totalPrice);
    }

    @Test
    void testIsDessert() {
        OrderItem dessertItem = new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(1));
        assertTrue(dessertItem.isDessert());
    }

    @Test
    void testIsMain() {
        OrderItem mainItem = new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1));
        assertTrue(mainItem.isMain());
    }

    @Test
    void testIsBeverageOrder() {
        OrderItem beverageItem = new OrderItem(Menu.RED_WINE, new MenuQuantity(1));
        assertTrue(beverageItem.isBeverageOrder());
    }

    @Test
    void testGetMenuName() {
        Menu menu = Menu.T_BONE_STEAK;
        OrderItem orderItem = new OrderItem(menu, new MenuQuantity(1));
        assertEquals(menu.getMenuName(), orderItem.getMenuName());
    }

    @Test
    void testGetKoreanName() {
        Menu menu = Menu.T_BONE_STEAK;
        OrderItem orderItem = new OrderItem(menu, new MenuQuantity(1));
        assertEquals(menu.getKoranName(), orderItem.getKoreanName());
    }

    @Test
    void testGetQuantity() {
        int quantityValue = 3;
        MenuQuantity quantity = new MenuQuantity(quantityValue);
        OrderItem orderItem = new OrderItem(Menu.T_BONE_STEAK, quantity);

        assertEquals(quantityValue, orderItem.getQuantity());
    }

    @Test
    void testCalculateDiscount() {
        int discountPerItem = 500;
        MenuQuantity quantity = new MenuQuantity(2);
        OrderItem orderItem = new OrderItem(Menu.T_BONE_STEAK, quantity);

        int discount = orderItem.calculateDiscount(discountPerItem);
        assertEquals(2 * discountPerItem, discount);
    }
}
