package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> splitCarName(String input) {
        return Arrays.asList(input.split(CAR_NAME_DELIMITER));
    }
}
