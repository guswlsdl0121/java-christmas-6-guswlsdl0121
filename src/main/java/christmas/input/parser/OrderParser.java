package christmas.input.parser;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.common.util.InputUtil;
import christmas.domain.Menu;
import christmas.input.result.OrderParseResult;
import christmas.input.validator.InputValidator;
import christmas.vo.order.MenuQuantity;
import christmas.vo.order.OrderItem;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderParser implements InputParser<OrderParseResult> {
    private static final String DELEMETER = InputConstant.ITEM_SEPARATOR.getValue();
    private final InputValidator<String> inputValidator;

    public OrderParser(InputValidator<String> inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public OrderParseResult parse(String input) {
        String noSpaceInput = input.replaceAll(InputConstant.WHITE_SPACE_FORMAT.getValue(),
                OutputMessage.NONE.getMessage());
        inputValidator.validate(noSpaceInput);
        List<OrderItem> orderItems = Arrays.stream(noSpaceInput.split(DELEMETER))
                .map(this::parseOrderItem)
                .collect(Collectors.toList());

        return new OrderParseResult(orderItems);
    }

    private OrderItem parseOrderItem(String itemInput) {
        String menuName = InputUtil.extractMenuName(itemInput);
        int quantity = InputUtil.extractQuantity(itemInput);

        Menu menu = Menu.findByMenuName(menuName)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage()));

        return new OrderItem(menu, new MenuQuantity(quantity));
    }
}
