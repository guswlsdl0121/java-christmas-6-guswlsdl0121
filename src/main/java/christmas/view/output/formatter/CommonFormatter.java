package christmas.view.output.formatter;

import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalAmount;
import java.text.NumberFormat;
import java.util.Locale;

public class CommonFormatter {
    private static final String WON_UNIT = OutputMessage.WON_UNIT.getMessage();
    private static final String WHITESPACE = InputConstant.WHITESPACE.getValue();
    private static final String ITEM_UNIT = OutputMessage.ITEM_UNIT.getMessage();

    public static String formatCurrency(int amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount) + WON_UNIT;
    }

    public static String formatBeforeDiscount(TotalAmount totalAmount) {
        return formatCurrency(totalAmount.amount());
    }

    public static String formatRewardItem(OrderItem rewardItem) {
        return rewardItem.getKoreanName() + WHITESPACE + rewardItem.getQuantity() + ITEM_UNIT;
    }
}
