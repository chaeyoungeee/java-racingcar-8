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

    public static Racing of(List<String> carNames, int tryCount) {
        return new Racing(Cars.of(carNames), Attempts.from(tryCount));
    }

    public void run(RandomNumberGenerator randomNumberGenerator) {
        attempts.decrement();
        cars.move(randomNumberGenerator);
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