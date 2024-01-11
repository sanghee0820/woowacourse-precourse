package baseball.type;

public enum Result {
    NOTHING(0, 0, "낫싱"),
    B1(1, 0, "1볼"),
    B2(2, 0, "2볼"),
    B3(3, 0, "3볼"),
    B0S1(0, 1, "1스트라이크"),
    B1S1(1, 1, "1볼 1스트라이크"),
    B2S1(2, 1, "2볼 1스트라이크"),
    B0S2(0, 2, "2스트라이크"),
    B0S3(0, 3, "3스트라이크");
    private final int ball;
    private final int strike;
    private final String output;

    Result(int ball, int strike, String output) {
        this.ball = ball;
        this.strike = strike;
        this.output = output;
    }

    public static Result getType(int ball, int strike) {
        for (Result result : Result.values()) {
            if (result.ball == ball && result.strike == strike) {
                return result;
            }
        }
        return Result.NOTHING;
    }

    @Override
    public String toString() {
        return this.output;
    }
}
