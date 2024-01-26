package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersDuplicated(List<Integer> numbers) {
        if (Sets.newHashSet(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Rank compare(final List<Integer> normal, final int bonus) {
        Set<Integer> union = new HashSet<>(normal);
        union.addAll(numbers);
        int normalCnt = 12 - union.size();
        if (normalCnt != 5) {
            return Rank.getRank(normalCnt, false);
        }
        return Rank.getRank(normalCnt, numbers.contains(bonus));
    }
}
