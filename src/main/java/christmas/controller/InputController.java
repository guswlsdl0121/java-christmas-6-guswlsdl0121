package christmas.controller;

import christmas.config.InputConfig;
import christmas.view.OutputView;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalOrder;
import java.time.LocalDate;
import java.util.List;

public class InputController {

    public TotalOrder proceedInput() {
        TotalOrder totalOrder = createTotalOrder();
        OutputView.printTotalOrder(totalOrder);
        return totalOrder;
    }

    private TotalOrder createTotalOrder() {
        LocalDate localDate = inputDate();
        List<OrderItem> orderItems = inputOrderItems();
        return new TotalOrder(localDate, orderItems);
    }

    private LocalDate inputDate() {
        OutputView.printStartMessage();
        return InputConfig.createDate().tryInput();
    }

    private List<OrderItem> inputOrderItems() {
        return InputConfig.createOrderItems().tryInput();
    }
}
