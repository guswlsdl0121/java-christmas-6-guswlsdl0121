package christmas.view.output.formatter;

import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.MessageConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.OrderItem;
import christmas.vo.order.TotalOrder;

public class TotalOrderFormatter {
    private static final String LINE_SEPARATOR = MessageConstant.LINE_SEPARATOR.getValue();
    private static final String WHITESPACE = InputConstant.WHITESPACE.getValue();
    private static final String ITEM_UNIT = OutputMessage.ITEM_UNIT.getMessage();

    public static String formatTotalOrder(TotalOrder totalOrder) {
        StringBuilder output = new StringBuilder();
        appendEventPreview(output, totalOrder);
        appendOrderItems(output, totalOrder);
        return output.toString();
    }

    private static void appendEventPreview(StringBuilder output, TotalOrder totalOrder) {
        int day = totalOrder.localDate().getDayOfMonth();
        output.append(OutputMessage.EVENT_PREVIEW.getMessageWithDate(day))
                .append(LINE_SEPARATOR)
                .append(LINE_SEPARATOR)
                .append(OutputMessage.ORDER_MENU_HEADER.getMessage())
                .append(LINE_SEPARATOR);
    }

    private static void appendOrderItems(StringBuilder output, TotalOrder totalOrder) {
        totalOrder.orderItems().forEach(item -> appendOrderItem(output, item));
    }

    private static void appendOrderItem(StringBuilder output, OrderItem item) {
        output.append(item.getKoreanName())
                .append(WHITESPACE)
                .append(item.getQuantity())
                .append(ITEM_UNIT)
                .append(LINE_SEPARATOR);
    }
}
