package christmas.view;

import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(OutputViewFormatter.formatStartMessage());
    }

    public static void printAnswerDateMessage() {
        System.out.println(OutputViewFormatter.formatAskDateMessage());
    }

    public static void printAnswerOrder() {
        System.out.println(OutputViewFormatter.formatAskOrderMessage());
    }

    public static void printError(String errorMessage) {
        System.out.println(OutputViewFormatter.formatErrorMessage(errorMessage));
    }

    public static void printTotalOrder(TotalOrder totalOrder) {
        System.out.println(OutputViewFormatter.formatTotalOrder(totalOrder));
    }

    public static void printBeforeDiscount(TotalAmount totalAmount) {
        System.out.println(OutputViewFormatter.formatBeforeDiscount(totalAmount));
    }

    public static void printRewardItem(OrderItem rewardItem) {
        System.out.println(OutputViewFormatter.formatRewardItem(rewardItem));
    }

    public static void printNoReward() {
        System.out.println(OutputViewFormatter.formatNoReward());
    }
}
