package christmas.controller;

import christmas.input.InputHandler;
import christmas.input.result.DateParseResult;
import christmas.input.result.OrderParseResult;
import christmas.view.output.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalOrder;
import java.time.LocalDate;
import java.util.List;

public class InputController {
    private final InputHandler<DateParseResult, LocalDate> dateInputHandler;
    private final InputHandler<OrderParseResult, List<OrderItem>> orderInputHandler;

    public InputController(InputHandler<DateParseResult, LocalDate> dateInputHandler,
                            InputHandler<OrderParseResult, List<OrderItem>> orderInputHandler) {
        this.dateInputHandler = dateInputHandler;
        this.orderInputHandler = orderInputHandler;
    }

    public TotalOrder proceedInput() {
        OutputView.printStartMessage();

        LocalDate date = dateInputHandler.tryInput();
        List<OrderItem> orderItems = orderInputHandler.tryInput();

        return new TotalOrder(date, orderItems);
    }
}
