package christmas.controller;

import christmas.common.config.InputConfig;
import christmas.view.OutputView;
import christmas.vo.order.OrderItems;
import java.time.LocalDate;

public class InputController {
    public LocalDate inputDate() {
        OutputView.printStartMessage();
        return InputConfig.createDate().tryInput();
    }

    public OrderItems inputOrderItems() {
        return InputConfig.createOrderItems().tryInput();
    }
}
