package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public class InputValidator {
    public static int validateBudget(String budget) throws IllegalArgumentException {
        try {
            Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return Integer.parseInt(budget);
    }

    public static List<Integer> validateNormalNumbers(String normalNumbers) throws IllegalArgumentException {
        return Stream.of(normalNumbers.split(",")).map(number -> Integer.valueOf(number.trim())).toList();
    }

    public static int validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        return Integer.parseInt(bonusNumber);
    }
}
