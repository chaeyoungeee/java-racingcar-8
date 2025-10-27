package racingcar.domain;

import racingcar.dto.CarStatusDto;
import racingcar.utils.RandomNumberGenerator;

public class Car {

    private final Name name;
    private final ForwardCount forwardCount;

    private Car(Name name) {
        this.name = name;
        this.forwardCount = ForwardCount.from(0);
    }

    public static Car from(String name) {
        return new Car(Name.from(name));
    }

    public void move(RandomNumberGenerator randomNumberGenerator, int threshold) {
        if (randomNumberGenerator.generate() >= threshold) {
            forwardCount.increment();
        }
    }

    public CarStatusDto getStatus() {
        return CarStatusDto.of(name, forwardCount);
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getForwardCountValue() {
        return forwardCount.getValue();
    }
}
