package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.utils.RandomNumberGenerator;

public class Racing {
    private final Cars cars;
    private final TryCount tryCount;

    private Racing(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static Racing of(List<String> carNames, int tryCount, RandomNumberGenerator randomNumberGenerator) {
        return new Racing(Cars.of(carNames, randomNumberGenerator), TryCount.from(tryCount));
    }

    public void run() {
        tryCount.decrement();
        cars.move();
    }

    public boolean can() {
        return tryCount.canAttempt();
    }

    public List<CarStatus> getResult() {
        return cars.getResult();
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }
}