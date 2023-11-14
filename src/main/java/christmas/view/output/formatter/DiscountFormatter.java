package christmas.view.output.formatter;

import christmas.common.constant.view.InputConstant;
import christmas.common.constant.view.MessageConstant;
import christmas.common.constant.view.OutputMessage;
import christmas.vo.discount.Discount;
import christmas.vo.order.OrderItem;
import java.util.List;
import java.util.Optional;

public class DiscountFormatter {
    private static final String LINE_SEPARATOR = MessageConstant.LINE_SEPARATOR.getValue();
    private static final String DASH = InputConstant.QUANTITY_SEPARATOR.getValue();
    private static final String WHITESPACE = InputConstant.WHITESPACE.getValue();
    private static final String COLON = InputConstant.COLON.getValue();
    private static final String REWARD = OutputMessage.REWARD_EVENT.getMessage();
    private static final String NONE = OutputMessage.NOTHING.getMessage();

    public static String formatDiscounts(List<Discount> discounts, Optional<OrderItem> rewardItem) {
        if (discounts.isEmpty() && rewardItem.isEmpty()) {
            return formatNoDiscountsOrReward();
        }
        return formatDiscountsAndReward(discounts, rewardItem);
    }

    private static String formatNoDiscountsOrReward() {
        return LINE_SEPARATOR + OutputMessage.BENEFIT_DETAILS.getMessage() + LINE_SEPARATOR + NONE;
    }

    private static String formatDiscountsAndReward(List<Discount> discounts, Optional<OrderItem> rewardItem) {
        StringBuilder output = new StringBuilder();
        output.append(LINE_SEPARATOR)
                .append(OutputMessage.BENEFIT_DETAILS.getMessage())
                .append(LINE_SEPARATOR);

        appendDiscounts(output, discounts);
        appendReward(output, rewardItem);

        return output.toString();
    }

    private static void appendDiscounts(StringBuilder output, List<Discount> discounts) {
        discounts.stream()
                .map(DiscountFormatter::formatSingleDiscount)
                .forEach(discountString -> appendDiscountString(output, discountString));
    }

    private static void appendReward(StringBuilder output, Optional<OrderItem> rewardItem) {
        rewardItem.ifPresent(item -> appendRewardItem(output, item));
    }

    private static void appendRewardItem(StringBuilder output, OrderItem item) {
        output.append(REWARD)
                .append(COLON)
                .append(WHITESPACE)
                .append(DASH)
                .append(CommonFormatter.formatCurrency(item.calculateTotalPrice()))
                .append(LINE_SEPARATOR);
    }


    private static String formatSingleDiscount(Discount discount) {
        return discount.discountType().getDiscountName() + COLON + WHITESPACE + DASH +
                CommonFormatter.formatCurrency(discount.discountAmount().amount());
    }

    private static void appendDiscountString(StringBuilder output, String discountString) {
        if (!discountString.equals(NONE)) {
            output.append(discountString).append(LINE_SEPARATOR);
        }
    }
}
