package lotto;

import java.util.List;
import org.assertj.core.util.Sets;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersDuplicated(numbers);
        validateNumbersLength(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateNumbersDuplicated(List<Integer> numbers){
        if (Sets.newHashSet(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }


}
