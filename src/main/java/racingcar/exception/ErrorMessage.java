package racingcar.exception;

public enum ErrorMessage {
    INPUT_BLANK("입력값이 빈 값입니다."),
    CAR_NAME_TOO_LONG("자동차 이름 최대 길이를 초과했습니다."),
    CAR_NAME_DUPLICATE("중복된 자동차 이름이 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}