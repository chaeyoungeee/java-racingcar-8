package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;
    private static final int MOVEMENT_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    private Cars(List<Car> cars, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Cars of(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = carNames.stream()
                                 .map(Car::from)
                                 .toList();
        return new Cars(cars, randomNumberGenerator);
    }

    public void move() {
        cars.forEach(car -> {
            int randomNumber = randomNumberGenerator.generate();
            car.move(randomNumber, MOVEMENT_THRESHOLD);
        });
    }

    public List<CarStatus> getResult() {
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