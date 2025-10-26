package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("랜덤값이 임계값 이상이면 자동차가 전진한다.")
    @ParameterizedTest
    @CsvSource({
        "5, 4",
        "4, 4",
    }
    ) void moveForward(int randomNumber, int threshold) {
        Car car = Car.from("");
        car.move(randomNumber, threshold);
        assertThat(car.getForwardCountValue()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 임계값 이하면 자동차가 움직이지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "4, 5",
            "3, 10",
    }
    ) void stop(int randomNumber, int threshold) {
        Car car = Car.from("");
        car.move(randomNumber, threshold);
        assertThat(car.getForwardCountValue()).isEqualTo(0);
    }
}