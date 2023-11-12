package christmas.view;

import christmas.common.constant.view.OutputMessage;

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
}
