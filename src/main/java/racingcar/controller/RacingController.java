package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.dto.CarStatusDto;
import racingcar.utils.DefaultRandomNumberGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racing racing = collectGameInputs();
        executeRaceAndPrintResults(racing);
        printGameWinners(racing);
    }

    private Racing collectGameInputs() {
        outputView.printCarNameInputMessage();
        List<String> carNames = inputView.inputCarName();
        outputView.printTryCountInputMessage();
        int tryCount = inputView.inputTryCount();
        outputView.println();
        RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
        return Racing.of(carNames, tryCount, randomNumberGenerator);
    }

    private void executeRaceAndPrintResults(Racing racing) {
        outputView.printResultOutputMessage();
        while (racing.hasAttemptsLeft()) {
            racing.run();
            List<CarStatusDto> result = racing.getResult();
            outputView.printResult(result);
            outputView.println();
        }
    }

    private void printGameWinners(Racing racing) {
        outputView.printWinnerOutputMessage();
        List<String> winners = racing.getWinners();
        outputView.printWinners(winners);
    }
}
