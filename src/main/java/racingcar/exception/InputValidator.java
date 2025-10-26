package racingcar.exception;

import static racingcar.exception.ErrorMessage.CAR_NAME_DUPLICATE;
import static racingcar.exception.ErrorMessage.CAR_NAME_TOO_LONG;
import static racingcar.exception.ErrorMessage.INPUT_BLANK;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> names) {
        names.forEach(name -> {
            validateNotBlank(name);
            validateMaxNameLength(name);
        });
        validateNoDuplicateNames(names);
    }

    public static void validateNotBlank(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }

    public static void validateMaxNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    public static void validateNoDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        names.forEach((name -> {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
            }
        }));
    }
}
