package christmas.view;

import christmas.common.constant.view.MessageConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.order.TotalOrder;

public class OutputView {
    private final static String LINE_SEPARATOR = MessageConstant.LINE_SEPARATOR.getValue();

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
        int day = totalOrder.localDate().getDayOfMonth();
        System.out.println(OutputMessage.EVENT_PREVIEW.getMessageWithDate(day) + LINE_SEPARATOR);
        System.out.println(OutputMessage.ORDER_MENU_HEADER.getMessage());
        totalOrder.orderItems().forEach(item ->
                System.out.println(item.getKoreanName() + " " + item.getQuantity() + "개")
        );
    }
}
