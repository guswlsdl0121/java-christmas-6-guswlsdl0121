package christmas.input;

import christmas.input.creator.ResultCreator;
import christmas.input.parser.InputParser;
import christmas.input.result.InputResult;
import christmas.view.driver.ViewDriver;

public class InputHandler<T extends InputResult, R> {
    private final InputParser<T> parser;
    private final ResultCreator<T, R> creator;
    private final ViewDriver viewDriver;

    public InputHandler(InputParser<T> parser, ResultCreator<T, R> creator, ViewDriver viewDriver) {
        this.parser = parser;
        this.creator = creator;
        this.viewDriver = viewDriver;
    }

    public R tryInput() {
        String input = viewDriver.ask();
        while (true) {
            try {
                T parseResult = parser.parse(input);
                return creator.create(parseResult);
            } catch (IllegalArgumentException e) {
                input = viewDriver.errorAndAsk(e.getMessage());
            }
        }
    }
}
