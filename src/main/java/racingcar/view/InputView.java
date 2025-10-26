package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputValidator;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    public String readInput() {
        return Console.readLine();
    }

    public List<String> inputCarName() {
        String input = readInput();
        List<String> carNames = splitCarName(input);
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public Integer inputTryCount() {
        String input = readInput();
        InputValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }

    public static List<String> splitCarName(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER)).toList();
    }
}
