package christmas;

import christmas.domain.EventBadge;
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

public class Launcher {
    public static void run() {
        // 입력 처리
        TotalOrder totalOrder = proceedOrder();

        // 주문 처리
        Orders orders = createOrder(totalOrder);

        // 할인 전 총액 계산
        TotalAmount totalAmount = calculateTotalAmountBeforeDiscount(orders);

        // 보상 결정
        Optional<OrderItem> reward = applyReward(totalAmount);

        // 할인 적용
        List<Discount> discounts = applyDiscount(totalOrder, orders);

        // 결과 계산 및 출력
        int totalBenefitAmount = calculateResult(totalAmount, reward, discounts);

        // 이벤트 배지 결정 및 출력
        determineBadge(totalBenefitAmount);
    }

    private static TotalOrder proceedOrder() {
        InputController inputController = new InputController(InputConfig.inputDate(), InputConfig.inputOrderItems());
        TotalOrder totalOrder = inputController.proceedInput();
        OutputView.printTotalOrder(totalOrder);
        return totalOrder;
    }

    private static Orders createOrder(TotalOrder totalOrder) {
        OrderController orderController = new OrderController();
        return orderController.createOrder(totalOrder);
    }

    private static TotalAmount calculateTotalAmountBeforeDiscount(Orders orders) {
        TotalAmount totalAmount = orders.calculateTotalAmount();
        OutputView.printBeforeDiscount(totalAmount);
        return totalAmount;
    }

    private static Optional<OrderItem> applyReward(TotalAmount totalAmount) {
        RewardController rewardController = new RewardController(RewardConfig.createRewardStrategy());
        Optional<OrderItem> reward = rewardController.applyReward(totalAmount);
        reward.ifPresentOrElse(OutputView::printRewardItem, OutputView::printNoReward);
        return reward;
    }

    private static List<Discount> applyDiscount(TotalOrder totalOrder, Orders orders) {
        DiscountController discountController = new DiscountController(new DiscountStrategyFactory());
        return discountController.applyDiscount(orders, totalOrder.localDate());
    }

    private static int calculateResult(TotalAmount totalAmount, Optional<OrderItem> reward, List<Discount> discounts) {
        ResultController resultController = new ResultController();
        DiscountResult discountResult = resultController.createDiscountResult(discounts);
        OutputView.printDiscounts(discountResult.discounts(), reward);

        int totalBenefitAmount = resultController.getTotalBenefitAmount(discountResult, reward);
        OutputView.printTotalBenefitAmount(totalBenefitAmount);

        int discountedTotalAmount = resultController.getDiscountedTotalAmount(discountResult, totalAmount);
        OutputView.printDiscountedTotalAmount(discountedTotalAmount);

        return totalBenefitAmount;
    }

    private static void determineBadge(int totalBenefitAmount) {
        List<EventBadge> eventBadges = EventBadge.determineBadges(totalBenefitAmount);
        OutputView.printBadges(eventBadges);
    }
}
