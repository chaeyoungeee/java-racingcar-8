package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatus;

public class Racing {
    private final Cars cars;
    private final TryCount tryCount;

    private Racing(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static Racing of(List<String> cars, int tryCount) {
        return new Racing(Cars.from(cars), TryCount.from(tryCount));
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }
}