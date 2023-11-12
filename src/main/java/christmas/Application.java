package christmas;

import christmas.controller.InputController;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        LocalDate date = inputController.inputDate();
    }
}
