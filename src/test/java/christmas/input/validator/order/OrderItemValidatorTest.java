package christmas.input.validator.order;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.order.OrderConstant;
import christmas.domain.Menu;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class OrderItemValidatorTest {

    private final OrderItemValidator validator = new OrderItemValidator();

    @Test
    void testValidateWithValidOrder() {
        List<OrderItem> orderItems = List.of(
                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(2)),
                new OrderItem(Menu.CHOCO_CAKE, new MenuQuantity(1))
        );
        assertDoesNotThrow(() -> validator.validate(orderItems));
    }

    @Test
    void testValidateDuplicateItems() {
        List<OrderItem> orderItems = List.of(
                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(1)),
                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(2))
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(orderItems);
        });
        assertEquals(ErrorMessage.INVALID_MENU.getMessage(), exception.getMessage());
    }

    @Test
    void testValidateExceededOrderQuantity() {
        int maxOrder = OrderConstant.MAX_ORDER_QUANTITY.getValue();
        List<OrderItem> orderItems = List.of(
                new OrderItem(Menu.T_BONE_STEAK, new MenuQuantity(maxOrder + 1))
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(orderItems);
        });
        assertEquals(ErrorMessage.ORDER_QUANTITY_EXCEEDED.getMessage(), exception.getMessage());
    }

    @Test
    void testValidateOnlyBeverages() {
        List<OrderItem> orderItems = List.of(
                new OrderItem(Menu.RED_WINE, new MenuQuantity(2)),
                new OrderItem(Menu.CHAMPAGNE, new MenuQuantity(1))
        );
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(orderItems);
        });
        assertEquals(ErrorMessage.BEVERAGES_ONLY_ORDER.getMessage(), exception.getMessage());
    }
}
