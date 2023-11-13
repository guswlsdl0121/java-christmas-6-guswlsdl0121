package christmas.input.creator;

import christmas.input.result.OrderParseResult;
import christmas.input.validator.InputValidator;
import christmas.vo.order.OrderItem;
import java.util.List;

public class OrderCreator implements ResultCreator<OrderParseResult, List<OrderItem>> {
    private final InputValidator<List<OrderItem>> inputValidator;

    public OrderCreator(InputValidator<List<OrderItem>> inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public List<OrderItem> create(OrderParseResult inputResult) {
        inputValidator.validate(inputResult.orderItems());
        return inputResult.orderItems();
    }
}
