package christmas.common.config;

import christmas.common.handler.InputHandler;
import christmas.common.parser.DateInputParser;
import christmas.common.parser.OrderInputParser;
import christmas.view.driver.DateViewDriver;
import christmas.view.driver.OrderViewDriver;
import christmas.vo.order.OrderItems;
import java.time.LocalDate;

public class InputConfig {
    private InputConfig() {
    }

    public static InputHandler<LocalDate> createDate() {
        return new InputHandler<>(
                new DateInputParser(),
                new DateViewDriver()
        );
    }

    public static InputHandler<OrderItems> createOrderItems() {
        return new InputHandler<>(
                new OrderInputParser(),
                new OrderViewDriver()
        );
    }
}
