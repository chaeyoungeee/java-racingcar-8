package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ErrorMessage;

class CarTest {
    @DisplayName("랜덤값이 임계값 이상이면 자동차가 전진한다.")
    @Test
    void moveForward() {
        Car car = Car.from("pobi");
        car.move(() -> 8, 4);
        assertThat(car.getForwardCountValue()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 임계값 이하면 자동차가 움직이지 않는다.")
    @Test
    void stop() {
        Car car = Car.from("pobi");
        car.move(() -> 0, 4);
        assertThat(car.getForwardCountValue()).isEqualTo(0);
    }

    @DisplayName("자동차 이름에 null 혹은 빈 값이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameBlank(String input) {
        assertThatThrownBy(() -> Name.validateNotBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_BLANK.getMessage());
    }

    @DisplayName("자동차의 이름이 최대 길이를 초과할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "longcarname", "1234567"})
    void carNameTooLong(String name) {
        assertThatThrownBy(() -> Name.validateMaxNameLength(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
    }
}