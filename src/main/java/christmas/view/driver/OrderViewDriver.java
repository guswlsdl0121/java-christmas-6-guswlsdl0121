package christmas.view.driver;

import christmas.view.OutputView;

public class OrderViewDriver extends AbstractViewDriver {
    @Override
    protected void printMessage() {
        OutputView.printAnswerOrder();
    }
}
