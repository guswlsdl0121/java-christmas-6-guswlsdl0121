package christmas.common.util.handler;

import christmas.common.util.parser.InputParser;
import christmas.common.util.validator.InputValidator;
import christmas.view.driver.ViewDriver;

public class InputHandler<T> {
    private final InputParser<T> parser;
    private final InputValidator<T> validator;
    private final ViewDriver viewDriver;

    public InputHandler(InputParser<T> parser, InputValidator<T> validator, ViewDriver viewDriver) {
        this.parser = parser;
        this.validator = validator;
        this.viewDriver = viewDriver;
    }

    public T tryInput() {
        String input = viewDriver.ask();
        while (true) {
            try {
                T parsedInput = parser.parse(input);
                validator.validate(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException e) {
                input = viewDriver.errorAndAsk(e.getMessage());
            }
        }
    }
}
