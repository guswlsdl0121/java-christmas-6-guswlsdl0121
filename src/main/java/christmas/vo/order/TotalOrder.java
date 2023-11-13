package christmas.vo.order;

import java.time.LocalDate;
import java.util.List;

public record TotalOrder(LocalDate localDate, List<OrderItem> orderItems) {
}
