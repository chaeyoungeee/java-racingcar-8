package racingcar.domain;

import static racingcar.exception.ErrorMessage.CAR_NAME_BLANK;
import static racingcar.exception.ErrorMessage.CAR_NAME_TOO_LONG;

public class Name {

    private final String value;
    private static final int MAX_NAME_LENGTH = 5;

    private Name(String value) {
        validate(value);
        this.value = value;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getValue() {
        return value;
    }

    private static void validate(String value) {
        validateNotBlank(value);
        validateMaxNameLength(value);
    }

    public static void validateNotBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK.getMessage());
        }
    }

    public static void validateMaxNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }
}
