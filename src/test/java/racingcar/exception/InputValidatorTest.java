package racingcar.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

class InputValidatorTest {

    @DisplayName("입력이 null 혹은 빈 값일 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameBlank(String input) {
        assertThatThrownBy(() -> InputValidator.validateNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_BLANK.getMessage());
    }

    @DisplayName("자동차의 이름이 최대 길이를 초과할 경우 예외가 발생한다.")
    @Test
    void carNameTooLong() {
        String input = "pobi,woni,junnnn";
        List<String> carNames = InputView.splitCarName(input);
        assertThatThrownBy(() -> carNames.forEach(InputValidator::validateMaxNameLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }

    @DisplayName("중복된 자동차 이름이 존재할 경우 예외가 발생한다.")
    @Test
    void carNameDuplicate() {
        String input = "pobi,woni,pobi";
        List<String> carNames = InputView.splitCarName(input);
        assertThatThrownBy(() -> InputValidator.validateNoDuplicateNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_DUPLICATE.getMessage());
    }

    @DisplayName("시도 횟수가 0 혹은 양의 정수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "-1",
            "one",
            "1.5"
    })
    void tryCountInvalid(String input) {
        assertThatThrownBy(() -> InputValidator.validatePositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching(ErrorMessage.TRY_COUNT_INVALID.getMessage() + "|" +
                        ErrorMessage.TRY_COUNT_NEGATIVE.getMessage());
    }
}