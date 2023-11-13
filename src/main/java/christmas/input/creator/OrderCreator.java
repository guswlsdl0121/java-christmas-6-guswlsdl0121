package christmas.input.creator;

import christmas.input.result.OrderParseResult;
import christmas.input.validator.InputValidator;
import christmas.vo.order.OrderItem;
import christmas.vo.order.OrderItems;
import java.util.List;

public class OrderCreator implements ResultCreator<OrderParseResult, OrderItems> {
    private final InputValidator<List<OrderItem>> inputValidator;

    public OrderCreator(InputValidator<List<OrderItem>> inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public OrderItems create(OrderParseResult inputResult) {
        inputValidator.validate(inputResult.orderItems());
        return new OrderItems(inputResult.orderItems());
    }
}
