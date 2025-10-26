package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;

public class OutputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printResultOutputMessage() {
        System.out.println(RESULT_OUTPUT_MESSAGE);
    }

    public void printWinnerOutputMessage() {
        System.out.print(WINNER_OUTPUT_MESSAGE);
    }

    public void println() {
        System.out.println();
    }

    public void printResult(List<CarStatus> result) {
        result.forEach(
                status -> {
                    System.out.println(status.getCarName() + " : " + "-".repeat(status.getForwardCount()));
                }
        );
    }

    public void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
    }
}