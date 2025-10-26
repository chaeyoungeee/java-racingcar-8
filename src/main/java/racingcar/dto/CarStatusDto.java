package racingcar.dto;

import racingcar.domain.ForwardCount;
import racingcar.domain.Name;

public class CarStatusDto {

    private final String name;
    private final int forwardCount;

    private CarStatusDto(String name, int forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public static CarStatusDto of(Name name, ForwardCount forwardCount) {
        return new CarStatusDto(name.getValue(), forwardCount.getValue());
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}