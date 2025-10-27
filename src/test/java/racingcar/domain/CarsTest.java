package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;
import racingcar.exception.ErrorMessage;
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

    @DisplayName("자동차들의 상태를 리스트로 반환한다.")
    @Test
    void getResult() {
        Cars cars = Cars.of(carNames);
        cars.move(customRandomNumberGenerator);
        List<CarStatusDto> results = cars.getResult();
        assertThat(results).hasSize(3);
        assertThat(results).extracting("name").containsExactlyElementsOf(carNames);
        assertThat(results).extracting("forwardCount").containsExactly(1, 0, 1);
    }

    @DisplayName("가장 멀리 간 자동차들을 리스트로 반환한다.")
    @Test
    void getWinner() {
        Cars cars = Cars.of(carNames);
        cars.move(customRandomNumberGenerator);
        List<String> winners = cars.getWinner();
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
    }

    @DisplayName("중복된 자동차 이름이 존재할 경우 예외가 발생한다.")
    @Test
    void carNameDuplicate() {
        String input = "pobi,woni,pobi";
        List<String> carNames = InputParser.splitCarName(input);
        List<Car> cars = Cars.mapToCars(carNames);
        assertThatThrownBy(() -> Cars.validateDuplicateCarNames(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
    }
}