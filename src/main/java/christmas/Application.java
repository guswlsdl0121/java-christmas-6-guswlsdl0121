package christmas;

import christmas.controller.InputController;
import christmas.controller.OrderController;
import christmas.view.OutputView;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;

public class Application {
    public static void main(String[] args) {
        //날짜, 주문 목록 입력
        InputController inputController = new InputController();
        TotalOrder totalOrder = inputController.getTotalOrder();

        //주문 내역 출력
        OutputView.printTotalOrder(totalOrder);

        //주문 생성, 할인 전 주문 총액 출력
        OrderController orderController = new OrderController(totalOrder);
        TotalAmount totalAmount = orderController.calculateTotalBeforeDiscount();
        OutputView.printBeforeDiscount(totalAmount);
    }
}
