package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    public String readInput() {
        return Console.readLine();
    }

    public List<String> inputCarName() {
        String input = readInput();
        return splitCarName(input);
    }

    public static List<String> splitCarName(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER)).toList();
    }
}
