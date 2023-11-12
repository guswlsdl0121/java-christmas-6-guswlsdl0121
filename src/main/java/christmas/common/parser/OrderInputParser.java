package christmas.common.parser;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.view.InputConstant;
import christmas.common.util.InputUtil;
import christmas.common.validator.OrderValidator;
import christmas.domain.menu.Menu;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import christmas.vo.order.OrderItems;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderInputParser implements InputParser<OrderItems> {
    private static final String DELEMETER = InputConstant.ITEM_SEPARATOR.getValue();

    @Override
    public OrderItems parse(String input) {
        OrderValidator.validateOrderInput(input);

        List<OrderItem> orderItems = Arrays.stream(input.split(DELEMETER))
                .map(this::parseOrderItem)
                .collect(Collectors.toList());

        return new OrderItems(orderItems);
    }

    private OrderItem parseOrderItem(String itemInput) {
        String menuName = InputUtil.extractMenuName(itemInput);
        int quantity = InputUtil.extractQuantity(itemInput);

        Menu menu = Menu.findByMenuName(menuName)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage()));

        return new OrderItem(menu, new MenuQuantity(quantity));
    }
}
