package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;
import racingcar.utils.InputParser;
import racingcar.utils.RandomNumberGenerator;

class CarsTest {

    private List<String> carNames;
    private RandomNumberGenerator customRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        String input = "pobi,woni,jun";
        carNames = InputParser.splitCarName(input);
        customRandomNumberGenerator = new RandomNumberGenerator() {
            private final int[] numbers = {5, 3, 4}; // pobi: 5(전진), woni: 3(정지), jun: 4(전진)
            private int index = 0;

            @Override
            public int generate() {
                return numbers[index++];
            }
        };
    }

    @DisplayName("랜덤값을 임계값(4) 이상으로 고정 시 모든 자동차들이 전진한다.")
    @Test
    void moveForward() {
        RandomNumberGenerator alwaysTen = () -> 10;
        Cars cars = Cars.of(carNames, alwaysTen);
        cars.move();
        cars.getResult().forEach(carStatus ->
                assertThat(carStatus.getForwardCount()).isEqualTo(1));
    }

    @DisplayName("랜덤값을 임계값(4) 이하로 고정 시 모든 자동차들이 움직이지 않는다.")
    @Test
    void stopAll() {
        RandomNumberGenerator alwaysZero = () -> 0;
        Cars cars = Cars.of(carNames, alwaysZero);
        cars.move();
        cars.getResult().forEach(carStatus ->
                assertThat(carStatus.getForwardCount()).isEqualTo(0));
    }

    @DisplayName("자동차들의 상태를 리스트로 반환한다.")
    @Test
    void getResult() {
        Cars cars = Cars.of(carNames, customRandomNumberGenerator);
        cars.move();
        List<CarStatusDto> results = cars.getResult();
        assertThat(results).hasSize(3);
        assertThat(results).extracting("name").containsExactlyElementsOf(carNames);
        assertThat(results).extracting("forwardCount").containsExactly(1, 0, 1);
    }

    @DisplayName("가장 멀리 간 자동차들을 리스트로 반환한다.")
    @Test
    void getWinner() {
        Cars cars = Cars.of(carNames, customRandomNumberGenerator);
        cars.move();
        List<String> winners = cars.getWinner();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }
}