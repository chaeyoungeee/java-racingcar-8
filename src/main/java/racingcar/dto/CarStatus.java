package racingcar.dto;

import racingcar.domain.ForwardCount;
import racingcar.domain.Name;

public class CarStatus {

    private final String carName;
    private final int forwardCount;

    private CarStatus(String carName, int forwardCount) {
        this.carName = carName;
        this.forwardCount = forwardCount;
    }

    public static CarStatus of(Name name, ForwardCount forwardCount) {
        return new CarStatus(name.getValue(), forwardCount.getValue());
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}