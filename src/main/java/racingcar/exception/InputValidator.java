package racingcar.exception;

import static racingcar.exception.ErrorMessage.INPUT_BLANK;
import static racingcar.exception.ErrorMessage.TRY_COUNT_INVALID;

public class InputValidator {

    public static void validateCarNamesInput(String input) {
        validateNotBlank(input);
    }

    public static void validateTryCountInput(String input) {
        validateNotBlank(input);
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_INVALID.getMessage());
        }
    }

    public static void validateNotBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }
}
