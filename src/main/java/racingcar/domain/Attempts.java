package racingcar.domain;

public class Attempts {

    private int value;

    private Attempts(int value) {
        this.value = value;
    }

    public static Attempts from(int tryCount) {
        return new Attempts(tryCount);
    }

    public void decrement() {
        value--;
    }

    public boolean hasLeft() {
        return value > 0;
    }
}
