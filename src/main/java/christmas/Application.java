package christmas;

import christmas.controller.InputController;
import christmas.view.OutputView;
import christmas.vo.order.TotalOrder;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        TotalOrder totalOrder = inputController.getTotalOrder();
        OutputView.printTotalOrder(totalOrder);
    }
}
