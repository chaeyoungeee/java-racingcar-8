package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatus;

public class Cars {

    private final List<Car> cars;
    private static final int MOVEMENT_THRESHOLD = 4;

    private Cars(List<String> cars) {
        this.cars = cars.stream().map(Car::from).toList();
    }

    public static Cars from(List<String> cars) {
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(car -> car.move(MOVEMENT_THRESHOLD));
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