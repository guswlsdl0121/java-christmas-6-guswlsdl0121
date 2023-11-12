package christmas.common.constant.view;

import java.util.regex.Pattern;

public enum InputFormat {
    ITEM_FORMAT_PATTERN(Pattern.compile("[가-힣]+-(1[0-9]|20|[1-9])"));

    private final Pattern pattern;

    InputFormat(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
