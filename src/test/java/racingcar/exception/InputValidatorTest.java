package racingcar.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class InputValidatorTest {

    @DisplayName("입력이 null 혹은 빈 값일 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameBlank(String input) {
        assertThatThrownBy(() -> InputValidator.validateNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_BLANK.getMessage());
    }
}