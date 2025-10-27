package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;
    private static final int MOVEMENT_THRESHOLD = 4;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();
        return new Cars(cars);
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(car -> {
            car.move(randomNumberGenerator, MOVEMENT_THRESHOLD);
        });
    }

    public List<CarStatusDto> getResult() {
        return cars.stream().map(Car::getStatus).toList();
    }

    public List<String> getWinner() {
        int maxForwardCount = cars.stream()
                .mapToInt(Car::getForwardCountValue)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getForwardCountValue() == maxForwardCount)
                .map(Car::getNameValue)
                .toList();
    }
}