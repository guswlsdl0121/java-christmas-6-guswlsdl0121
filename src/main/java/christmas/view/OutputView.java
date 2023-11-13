package christmas.view;

import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;

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
        String formattedOrder = OutputViewFormatter.formatTotalOrder(totalOrder);
        System.out.println(formattedOrder);
    }

    public static void printBeforeDiscount(TotalAmount totalAmount) {
        String formattedAmount = OutputViewFormatter.formatCurrency(totalAmount.amount());
        System.out.println(OutputMessage.TOTAL_BEFORE_DISCOUNT.getMessage());
        System.out.println(formattedAmount);
    }
}
