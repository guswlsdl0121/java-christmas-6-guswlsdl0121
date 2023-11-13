package christmas.view;

import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.MessageConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import christmas.vo.order.TotalOrder;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputViewFormatter {
    private static final String LINE_SEPARATOR = MessageConstant.LINE_SEPARATOR.getValue();
    private static final String WHITESPACE = InputConstant.WHITESPACE.getValue();
    private static final String ITEM_UNIT = OutputMessage.ITEM_UNIT.getMessage();
    private static final String WON_UNIT = OutputMessage.WON_UNIT.getMessage();

    public static String formatStartMessage() {
        return OutputMessage.GREETING.getMessage();
    }

    public static String formatAskDateMessage() {
        return OutputMessage.ASK_DATE.getMessage();
    }

    public static String formatAskOrderMessage() {
        return OutputMessage.ASK_ORDER.getMessage();
    }

    public static String formatErrorMessage(String errorMessage) {
        return errorMessage;
    }

    public static String formatTotalOrder(TotalOrder totalOrder) {
        StringBuilder output = new StringBuilder();
        int day = totalOrder.localDate().getDayOfMonth();
        output.append(OutputMessage.EVENT_PREVIEW.getMessageWithDate(day))
                .append(LINE_SEPARATOR)
                .append(LINE_SEPARATOR)
                .append(OutputMessage.ORDER_MENU_HEADER.getMessage())
                .append(LINE_SEPARATOR);

        for (OrderItem item : totalOrder.orderItems()) {
            output.append(item.getKoreanName())
                    .append(WHITESPACE)
                    .append(item.getQuantity())
                    .append(ITEM_UNIT)
                    .append(LINE_SEPARATOR);
        }
        return output.toString();
    }

    public static String formatCurrency(int amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount) + WON_UNIT;
    }

    public static String formatRewardItem(OrderItem rewardItem) {
        return rewardItem.getKoreanName() + WHITESPACE + rewardItem.getQuantity() + ITEM_UNIT;
    }

    public static String formatBeforeDiscount(TotalAmount totalAmount) {
        return OutputMessage.TOTAL_BEFORE_DISCOUNT.getMessage() + LINE_SEPARATOR +
                formatCurrency(totalAmount.amount());
    }

    public static String formatNoReward() {
        return LINE_SEPARATOR + OutputMessage.BONUS_ITEM_HEADER.getMessage() + LINE_SEPARATOR + "없음";
    }
}
