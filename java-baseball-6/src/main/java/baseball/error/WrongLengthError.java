package baseball.error;

public class WrongLengthError extends IllegalArgumentException {
    public WrongLengthError() {
        this(ErrorType.WRONG_LENGTH, "");
    }

    public WrongLengthError(String from) {
        this(ErrorType.WRONG_LENGTH, from);
    }

    private WrongLengthError(ErrorType errorType, String from) {
        super(errorType.getErrorMessage() + from);
    }

}
