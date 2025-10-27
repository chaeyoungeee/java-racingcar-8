package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("랜덤값이 임계값 이상이면 자동차가 전진한다.")
    @Test
    void moveForward() {
        Car car = Car.from("");
        car.move(() -> 8, 4);
        assertThat(car.getForwardCountValue()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 임계값 이하면 자동차가 움직이지 않는다.")
    @Test
    void stop() {
        Car car = Car.from("");
        car.move(() -> 0, 4);
        assertThat(car.getForwardCountValue()).isEqualTo(0);
    }
}