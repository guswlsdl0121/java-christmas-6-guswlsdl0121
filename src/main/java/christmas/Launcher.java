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

public class Launcher {
    public static void run() {
        // 기존 로직 유지
        TotalOrder totalOrder = inputOrder();
        Orders orders = processOrder(totalOrder);
        TotalAmount totalAmount = calculateTotalAmount(orders);
        Optional<OrderItem> reward = determineReward(totalAmount);
        List<Discount> discounts = applyDiscounts(orders, totalOrder);

        // 결과 계산 및 출력
        DiscountResult discountResult = calculateDiscountResult(discounts);
        int totalBenefit = calculateAndPrintTotalBenefit(discountResult, reward);
        calculateAndPrintDiscountedTotal(discountResult, totalAmount);
    }

    private static TotalOrder inputOrder() {
        InputController inputController = new InputController(
                InputConfig.inputDate(),
                InputConfig.inputOrderItems()
        );
        TotalOrder totalOrder = inputController.proceedInput();
        OutputView.printTotalOrder(totalOrder);
        return totalOrder;
    }

    private static Orders processOrder(TotalOrder totalOrder) {
        OrderController orderController = new OrderController();
        return orderController.createOrder(totalOrder);
    }

    private static TotalAmount calculateTotalAmount(Orders orders) {
        TotalAmount totalAmount = orders.calculateTotalAmountBeforeDiscount();
        OutputView.printBeforeDiscount(totalAmount);
        return totalAmount;
    }

    private static Optional<OrderItem> determineReward(TotalAmount totalAmount) {
        RewardController rewardController = new RewardController(RewardConfig.createRewardStrategy());
        Optional<OrderItem> reward = rewardController.applyReward(totalAmount);
        reward.ifPresentOrElse(
                OutputView::printRewardItem,
                OutputView::printNoReward
        );
        return reward;
    }

    private static List<Discount> applyDiscounts(Orders orders, TotalOrder totalOrder) {
        DiscountController discountController = new DiscountController(new DiscountStrategyFactory());
        return discountController.applyDiscount(orders, totalOrder.localDate());
    }

    private static DiscountResult calculateDiscountResult(List<Discount> discounts) {
        ResultController resultController = new ResultController();
        return resultController.createDiscountResult(discounts);
    }

    private static int calculateAndPrintTotalBenefit(DiscountResult discountResult, Optional<OrderItem> reward) {
        ResultController resultController = new ResultController();
        int totalBenefitAmount = resultController.getTotalBenefitAmount(discountResult, reward);
        OutputView.printTotalBenefitAmount(totalBenefitAmount);
        return totalBenefitAmount;
    }

    private static void calculateAndPrintDiscountedTotal(DiscountResult discountResult, TotalAmount totalAmount) {
        ResultController resultController = new ResultController();
        int discountedTotalAmount = resultController.getDiscountedTotalAmount(discountResult, totalAmount);
        OutputView.printDiscountedTotalAmount(discountedTotalAmount);
    }
}
