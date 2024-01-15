package baseball.error;

public class WrongTypeError extends IllegalArgumentException {
    public WrongTypeError() {
        this(ErrorType.WRONG_TYPE, "");
    }

    public WrongTypeError(String from) {
        this(ErrorType.WRONG_TYPE, from);
    }

    private WrongTypeError(ErrorType errorType, String from) {
        super(errorType.getErrorMessage() + from);
    }

}
