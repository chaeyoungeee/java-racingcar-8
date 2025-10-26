package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.dto.CarStatus;
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
        return Racing.of(carNames, tryCount);
    }

    private void executeRaceAndPrintResults(Racing racing) {
        outputView.printResultOutputMessage();
        while (racing.can()) {
            racing.run();
            List<CarStatus> result = racing.getResult();
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
