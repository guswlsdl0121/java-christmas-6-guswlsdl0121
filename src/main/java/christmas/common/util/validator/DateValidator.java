package christmas.common.util.validator;

import java.time.LocalDate;

public class DateValidator implements InputValidator<LocalDate> {

    @Override
    public void validate(LocalDate input) {
        //Date의 추가적인 비지니스 예외를 이곳에 구현할 수 있다.
    }
}
