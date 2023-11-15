package christmas.common.constant.view;

import java.util.regex.Pattern;

public enum InputFormat {
    ITEM_FORMAT_PATTERN(Pattern.compile("[가-힣]+-[1-9][0-9]*")),
    DAY_PATTERN(Pattern.compile("^(3[01]|[12][0-9]|0?[1-9])$"));
    private final Pattern pattern;

    InputFormat(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
