package christmas.common.config;

import christmas.common.util.handler.InputHandler;
import christmas.common.util.parser.DateInputNumberParser;
import christmas.common.util.validator.DateValidator;
import christmas.view.driver.DateViewDriver;
import java.time.LocalDate;

public class InputConfig {
    private InputConfig() {
    }

    public static InputHandler<LocalDate> createDate() {
        return new InputHandler<>(
                new DateInputNumberParser(),
                new DateValidator(),
                new DateViewDriver()
        );
    }
}
