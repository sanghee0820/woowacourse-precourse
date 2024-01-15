package baseball.error;

public enum ErrorType {
    WRONG_TYPE("입력이 숫자 타입이 아님."),
    WRONG_LENGTH("입력이 올바른 길이가 아님"),
    WRONG_MENU("입력이 올바른 메뉴 번호가 아님.");

    private final String errorMessage;

    ErrorType(String error) {
        this.errorMessage = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}
