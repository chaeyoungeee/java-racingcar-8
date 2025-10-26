package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.utils.RandomNumberGenerator;

public class Racing {
    
    private final Cars cars;
    private final Attempts attempts;

    private Racing(Cars cars, Attempts attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public static Racing of(List<String> carNames, int tryCount, RandomNumberGenerator randomNumberGenerator) {
        return new Racing(Cars.of(carNames, randomNumberGenerator), Attempts.from(tryCount));
    }

    public void run() {
        attempts.decrement();
        cars.move();
    }

    public boolean hasAttemptsLeft() {
        return attempts.hasLeft();
    }

    public List<CarStatusDto> getResult() {
        return cars.getResult();
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }
}