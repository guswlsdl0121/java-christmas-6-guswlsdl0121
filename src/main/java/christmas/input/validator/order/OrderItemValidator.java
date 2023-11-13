package christmas.input.validator.order;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.order.OrderConstant;
import christmas.input.validator.InputValidator;
import christmas.vo.order.OrderItem;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderItemValidator implements InputValidator<List<OrderItem>> {
    private static final int NOT_EXIST = 0;
    private static final int MAX_ORDER = OrderConstant.MAX_ORDER_QUANTITY.getValue();

    private static void validateOrderQuantity(List<OrderItem> orderItems) {
        int totalQuantity = orderItems.stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();

        if (totalQuantity > MAX_ORDER) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_QUANTITY_EXCEEDED.getMessage());
        }
    }

    private static void validateNotOnlyBeverages(List<OrderItem> orderItems) {
        long nonBeverageCount = orderItems.stream()
                .filter(orderItem -> !orderItem.isBeverageOrder())
                .count();

        if (nonBeverageCount == NOT_EXIST) {
            throw new IllegalArgumentException(ErrorMessage.BEVERAGES_ONLY_ORDER.getMessage());
        }
    }

    @Override
    public void validate(List<OrderItem> orderItems) {
        validateDuplicate(orderItems);
        validateOrderQuantity(orderItems);
        validateNotOnlyBeverages(orderItems);
    }

    private void validateDuplicate(List<OrderItem> orderItems) {
        Set<String> uniqueMenuNames = new HashSet<>();
        for (OrderItem item : orderItems) {
            validateNonDuplicate(item, uniqueMenuNames);
        }
    }

    private void validateNonDuplicate(OrderItem item, Set<String> uniqueMenuNames) {
        if (!uniqueMenuNames.add(item.getMenuName())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }
}
