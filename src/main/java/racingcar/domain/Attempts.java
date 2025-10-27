package racingcar.domain;

import static racingcar.exception.ErrorMessage.TRY_COUNT_NEGATIVE;

public class Attempts {

    private int value;

    private Attempts(int value) {
        getValidatePositiveInteger(value);
        this.value = value;
    }

    public static Attempts from(int tryCount) {
        return new Attempts(tryCount);
    }

    public void decrement() {
        value--;
    }

    public boolean hasLeft() {
        return value > 0;
    }

    private static void getValidatePositiveInteger(int value) {
        validatePositiveInteger(value);
    }

    public static void validatePositiveInteger(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(TRY_COUNT_NEGATIVE.getMessage());
        }
    }
}
