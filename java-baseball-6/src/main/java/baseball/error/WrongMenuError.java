package baseball.error;

public class WrongMenuError extends IllegalArgumentException {
    public WrongMenuError() {
        this(ErrorType.WRONG_MENU, "");
    }

    public WrongMenuError(String from) {
        this(ErrorType.WRONG_MENU, from);
    }

    public WrongMenuError(ErrorType errorType, String from) {
        super(errorType.getErrorMessage() + from);
    }
}
