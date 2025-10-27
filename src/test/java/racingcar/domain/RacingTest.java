package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;
import racingcar.utils.DefaultRandomNumberGenerator;
import racingcar.utils.InputParser;
import racingcar.utils.RandomNumberGenerator;

class RacingTest {

    private List<String> carNames;
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        String input = "pobi,woni,jun";
        carNames = InputParser.splitCarName(input);
        randomNumberGenerator = new DefaultRandomNumberGenerator();
    }

    @DisplayName("시도 횟수가 0 혹은 양의 정수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "-100",
    })
    void tryCountInvalid(int input) {
        assertThatThrownBy(() -> Attempts.validatePositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.TRY_COUNT_NEGATIVE.getMessage());
    }

    @DisplayName("시도 횟수가 남아있으면 true를 반환한다.")
    @Test
    void hasAttemptsLeft() {
        Racing racing = Racing.of(carNames, 3);
        assertTrue(racing.hasAttemptsLeft());
    }

    @DisplayName("시도 횟수가 모두 소진되면 false를 반환한다.")
    @Test
    void noAttemptsLeft() {
        int tryCount = 3;
        Racing racing = Racing.of(carNames, tryCount);
        while (tryCount-- > 0) {
            racing.run(randomNumberGenerator);
        }
        assertFalse(racing.hasAttemptsLeft());
    }
}