package christmas.input.result;

import christmas.vo.order.OrderItem;
import java.util.List;

public record OrderParseResult(List<OrderItem> orderItems) implements InputResult {
}
