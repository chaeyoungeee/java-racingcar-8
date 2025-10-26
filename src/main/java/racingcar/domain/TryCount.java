package racingcar.domain;

public class TryCount {
    private int value;

    private TryCount(int value) {
        this.value = value;
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public void decrement() {
        value--;
    }

    public boolean canAttempt() {
        return value > 0;
    }
}
