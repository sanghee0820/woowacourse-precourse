package baseball.domain;

import baseball.service.ValueGenerator;
import baseball.type.Result;
import java.util.HashSet;
import java.util.List;

public class Computer {
    private final List<Integer> value;

    public Computer() {
        this(ValueGenerator.getRandomValue());
    }

    public Computer(List<Integer> value) {
        this.value = value;
    }

    public Result compareValue(List<Integer> input) {
        validateInput(input);
        int ball = 0, strike = 0;

        for (int inputIndex = 0; inputIndex < 3; inputIndex++) {
            if (input.get(inputIndex).equals(this.value.get(inputIndex))) {
                strike++;
                continue;
            }
            if (this.value.contains(input.get(inputIndex))) {
                ball++;
            }
        }
        return Result.getType(ball, strike);
    }

    private void validateInput(List<Integer> input) throws IllegalArgumentException {
        HashSet<Integer> hashSet = new HashSet<>(input);
        if (hashSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
