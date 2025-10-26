package racingcar.domain;

import racingcar.dto.CarStatus;
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

    public void move(int threshold) {
        int randomNumber = RandomNumberGenerator.generate();
        if (randomNumber >= threshold) {
            forwardCount.increment();
        }
}
