package christmas.view.output;

import christmas.common.constant.view.OutputMessage;
import christmas.view.output.formatter.CommonFormatter;
import christmas.view.output.formatter.DiscountFormatter;
import christmas.view.output.formatter.TotalOrderFormatter;
import christmas.vo.discount.Discount;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;
import java.util.List;
import java.util.Optional;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(OutputMessage.GREETING.getMessage());
    }

    public static void printAnswerDateMessage() {
        System.out.println(OutputMessage.ASK_DATE.getMessage());
    }

    public static void printAnswerOrder() {
        System.out.println(OutputMessage.ASK_ORDER.getMessage());
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printTotalOrder(TotalOrder totalOrder) {
        System.out.println(TotalOrderFormatter.formatTotalOrder(totalOrder));
    }

    public static void printBeforeDiscount(TotalAmount totalAmount) {
        System.out.println(OutputMessage.TOTAL_BEFORE_DISCOUNT.getMessage());
        System.out.println(CommonFormatter.formatBeforeDiscount(totalAmount));
    }

    public static void printRewardItem(OrderItem rewardItem) {
        System.out.println();
        System.out.println(OutputMessage.BONUS_ITEM_HEADER.getMessage());
        System.out.println(CommonFormatter.formatRewardItem(rewardItem));
    }

    public static void printNoReward() {
        System.out.println();
        System.out.println(OutputMessage.BONUS_ITEM_HEADER.getMessage());
        System.out.println(OutputMessage.NOTHING.getMessage());
    }

    public static void printDiscounts(List<Discount> discounts, Optional<OrderItem> rewardItem) {
        System.out.println(DiscountFormatter.formatDiscounts(discounts, rewardItem));
    }
}
