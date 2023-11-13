package christmas.view;

import christmas.common.constant.view.MessageConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalOrder;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputViewFormatter {
    private final static String LINE_SEPARATOR = MessageConstant.LINE_SEPARATOR.getValue();

    public static String formatTotalOrder(TotalOrder totalOrder) {
        StringBuilder output = new StringBuilder();
        int day = totalOrder.localDate().getDayOfMonth();
        output.append(OutputMessage.EVENT_PREVIEW.getMessageWithDate(day)).append(LINE_SEPARATOR).append(LINE_SEPARATOR);
        output.append(OutputMessage.ORDER_MENU_HEADER.getMessage()).append(LINE_SEPARATOR);

        for (OrderItem item : totalOrder.orderItems()) {
            output.append(item.getKoreanName())
                    .append(" ")
                    .append(item.getQuantity())
                    .append("개")
                    .append(LINE_SEPARATOR);
        }

        return output.toString();
    }

    public static String formatCurrency(int amount) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount) + "원";
    }

}
