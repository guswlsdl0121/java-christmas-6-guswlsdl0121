package christmas.common.util;

import christmas.common.constant.error.ErrorMessage;

public class ParserWrapper {
    public static int parseQuantity(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }
}
