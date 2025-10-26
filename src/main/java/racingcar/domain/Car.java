package racingcar.domain;

import racingcar.dto.CarStatus;

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

    public void move(int randomNumber, int threshold) {
        if (randomNumber >= threshold) {
            forwardCount.increment();
        }
    }

    public CarStatus getStatus() {
        return CarStatus.of(name, forwardCount);
    }

    public String getNameValue() {
        return name.getValue();
    }

    public int getForwardCountValue() {
        return forwardCount.getValue();
    }
}
