package christmas.config;

import christmas.input.InputHandler;
import christmas.input.creator.DateCreator;
import christmas.input.creator.OrderCreator;
import christmas.input.parser.DateParser;
import christmas.input.parser.OrderParser;
import christmas.input.result.DateParseResult;
import christmas.input.result.OrderParseResult;
import christmas.input.validator.date.DateValidator;
import christmas.input.validator.order.OrderFormatValidator;
import christmas.input.validator.order.OrderItemValidator;
import christmas.view.driver.DateViewDriver;
import christmas.view.driver.OrderViewDriver;
import christmas.vo.order.OrderItem;
import java.time.LocalDate;
import java.util.List;

public class InputConfig {

    public static InputHandler<DateParseResult, LocalDate> inputDate() {
        return new InputHandler<>(
                new DateParser(new DateValidator()),
                new DateCreator(),
                new DateViewDriver()
        );
    }

    public static InputHandler<OrderParseResult, List<OrderItem>> inputOrderItems() {
        return new InputHandler<>(
                new OrderParser(new OrderFormatValidator()),
                new OrderCreator(new OrderItemValidator()),
                new OrderViewDriver()
        );
    }
}
