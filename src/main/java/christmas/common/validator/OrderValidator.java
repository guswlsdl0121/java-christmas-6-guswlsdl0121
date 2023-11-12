package christmas.common.validator;

import christmas.common.constant.error.ErrorMessage;
import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.InputFormat;
import christmas.common.util.InputUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class OrderValidator {
    private static final Pattern ITEM_FORMAT_PATTERN = InputFormat.ITEM_FORMAT_PATTERN.getPattern();

    public static void validateOrderInput(String input) {
        validateDuplicate(input);
        validateFormat(input);
    }

    private static void validateDuplicate(String input) {
        Set<String> uniqueMenuNames = new HashSet<>();
        Arrays.stream(input.split(InputConstant.ITEM_SEPARATOR.getValue()))
                .map(InputUtil::extractMenuName)
                .forEach(menuName -> addOrThrowIfDuplicate(uniqueMenuNames, menuName));
    }

    private static void validateFormat(String input) {
        Arrays.stream(input.split(InputConstant.ITEM_SEPARATOR.getValue()))
                .forEach(OrderValidator::checkFormat);
    }

    private static void addOrThrowIfDuplicate(Set<String> uniqueMenuNames, String menuName) {
        if (!uniqueMenuNames.add(menuName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }

    private static void checkFormat(String item) {
        if (!ITEM_FORMAT_PATTERN.matcher(item).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MENU.getMessage());
        }
    }
}
