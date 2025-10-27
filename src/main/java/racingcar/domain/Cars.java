package racingcar.domain;

import static racingcar.exception.ErrorMessage.CAR_NAME_DUPLICATE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.dto.CarStatusDto;
import racingcar.utils.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;
    private static final int MOVEMENT_THRESHOLD = 4;

    private Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = mapToCars(carNames);
        return new Cars(cars);
    }

    public static List<Car> mapToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .toList();
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

    public static void validate(List<Car> cars) {
        validateDuplicateCarNames(cars);
    }

    public static void validateDuplicateCarNames(List<Car> cars) {
        Set<String> names = new HashSet<>();
        cars.forEach(car -> {
            if (!names.add(car.getNameValue())) {
                throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
            }
        });
    }
}