package racingcar.view;

import static racingcar.utils.InputParser.splitCarName;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InputValidator;

public class InputView {

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
}
