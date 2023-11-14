package christmas;

import christmas.common.factory.DiscountStrategyFactory;
import christmas.config.InputConfig;
import christmas.config.RewardConfig;
import christmas.controller.DiscountController;
import christmas.controller.InputController;
import christmas.controller.OrderController;
import christmas.controller.ResultController;
import christmas.controller.RewardController;
import christmas.domain.DiscountResult;
import christmas.domain.Orders;
import christmas.view.output.OutputView;
import christmas.vo.discount.Discount;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        //날짜, 주문 목록 입력
        InputController inputController = new InputController(
                InputConfig.inputDate(),
                InputConfig.inputOrderItems()
        );
        TotalOrder totalOrder = inputController.proceedInput();
        OutputView.printTotalOrder(totalOrder);

        //주문 생성, 할인 전 주문 총액 출력
        OrderController orderController = new OrderController();
        Orders orders = orderController.createOrder(totalOrder);
        TotalAmount totalAmount = orderController.calculateTotalBeforeDiscount();
        OutputView.printBeforeDiscount(totalAmount);

        // 증정 메뉴 결정 및 출력
        RewardController rewardController = new RewardController(RewardConfig.createRewardStrategy());
        Optional<OrderItem> reward = rewardController.applyReward(totalAmount);
        reward.ifPresentOrElse(
                OutputView::printRewardItem,
                OutputView::printNoReward
        );

        //할인 정책 적용
        DiscountController discountController = new DiscountController(new DiscountStrategyFactory());
        List<Discount> discounts = discountController.applyDiscount(orders, totalOrder.localDate());
        OutputView.printDiscounts(discounts, reward);

        ResultController resultController = new ResultController();

        // DiscountResult 객체 생성
        DiscountResult discountResult = resultController.createDiscountResult(discounts);

        // 총 혜택 금액 계산 및 출력
        int totalBenefitAmount = resultController.getTotalBenefitAmount(discountResult, reward);
        OutputView.printTotalBenefitAmount(totalBenefitAmount);

        // 할인 후 예상 결제 금액 계산 및 출력
        int discountedTotalAmount = resultController.getDiscountedTotalAmount(discountResult, totalAmount);
        OutputView.printDiscountedTotalAmount(discountedTotalAmount);
    }
}
