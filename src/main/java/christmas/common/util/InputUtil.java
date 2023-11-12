package christmas.common.util;

import christmas.common.constant.view.InputConstant;

public class InputUtil {
    private static final int MENU_NAME_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;

    public static String extractMenuName(String itemInput) {
        return extractParts(itemInput)[MENU_NAME_INDEX].trim();
    }

    public static int extractQuantity(String itemInput) {
        return ParserWrapper.parseQuantity(extractParts(itemInput)[QUANTITY_INDEX].trim());
    }

    private static String[] extractParts(String itemInput) {
        return itemInput.split(InputConstant.QUANTITY_SEPARATOR.getValue());
    }
}
