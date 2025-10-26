package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.InputParser;
import racingcar.utils.RandomNumberGenerator;

class CarsTest {

    @DisplayName("랜덤값을 임계값(4) 이상으로 고정 시 모든 자동차들이 전진한다.")
    @Test
    void moveForward() {
        String input = "pobi,woni,jun";
        List<String> carNames = InputParser.splitCarName(input);
        RandomNumberGenerator alwaysTen = () -> 10;
        Cars cars = Cars.of(carNames, alwaysTen);
        cars.move();
        cars.getResult().forEach(carStatus ->
                assertThat(carStatus.getForwardCount()).isEqualTo(1));
    }

    @DisplayName("랜덤값을 임계값(4) 이하로 고정 시 모든 자동차들이 움직이지 않는다.")
    @Test
    void stopAll() {
        String input = "pobi,woni,jun";
        List<String> carNames = InputParser.splitCarName(input);
        RandomNumberGenerator alwaysZero = () -> 0;
        Cars cars = Cars.of(carNames, alwaysZero);
        cars.move();
        cars.getResult().forEach(carStatus ->
                assertThat(carStatus.getForwardCount()).isEqualTo(0));
    }
}