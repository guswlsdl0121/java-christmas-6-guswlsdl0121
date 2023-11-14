package christmas.view.driver;

import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public abstract class AbstractViewDriver implements ViewDriver {
    @Override
    public String ask() {
        printMessage();
        return InputView.readInput();
    }

    @Override
    public String errorAndAsk(String errorMessage) {
        OutputView.printError(errorMessage);
        return ask();
    }

    protected abstract void printMessage();
}
