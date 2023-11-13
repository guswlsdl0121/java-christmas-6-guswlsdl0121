package christmas;

import christmas.common.strategy.reward.RewardStrategy;
import christmas.config.RewardConfig;
import christmas.controller.InputController;
import christmas.controller.OrderController;
import christmas.controller.RewardController;
import christmas.domain.order.Orders;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        //날짜, 주문 목록 입력
        InputController inputController = new InputController();
        TotalOrder totalOrder = inputController.proceedInput();

        //주문 생성, 할인 전 주문 총액 출력
        OrderController orderController = new OrderController();
        Orders orders = orderController.proceedOrder(totalOrder);
        TotalAmount totalAmount = orderController.calculateTotalBeforeDiscount();

        // 증정 메뉴 결정 및 출력
        RewardStrategy rewardStrategy = RewardConfig.createRewardStrategy();
        RewardController rewardController = new RewardController(rewardStrategy);
        Optional<OrderItem> reward = rewardController.determineReward(totalAmount);
    }
}
