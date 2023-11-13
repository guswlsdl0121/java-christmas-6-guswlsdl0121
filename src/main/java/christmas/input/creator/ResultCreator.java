package christmas.input.creator;

import christmas.input.result.InputResult;

public interface ResultCreator<T extends InputResult, R> {
    R create(T inputResult);
}
