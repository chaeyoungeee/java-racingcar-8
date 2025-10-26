package racingcar.domain;

public class ForwardCount {

    private int value;

    private ForwardCount(int value) {
        this.value = value;
    }

    public static ForwardCount from(int forwardCount) {
        return new ForwardCount(forwardCount);
    }

    public void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
