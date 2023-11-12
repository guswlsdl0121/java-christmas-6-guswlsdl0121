package christmas.common.handler;

import christmas.common.parser.InputParser;
import christmas.common.validator.CommonValidator;
import christmas.view.driver.ViewDriver;

public class InputHandler<T> {
    private final InputParser<T> parser;
    private final ViewDriver viewDriver;

    public InputHandler(InputParser<T> parser, ViewDriver viewDriver) {
        this.parser = parser;
        this.viewDriver = viewDriver;
    }

    public T tryInput() {
        String input = viewDriver.ask();
        while (true) {
            try {
                CommonValidator.validateNotBlank(input);
                return parser.parse(input);
            } catch (IllegalArgumentException e) {
                input = viewDriver.errorAndAsk(e.getMessage());
            }
        }
    }
}
