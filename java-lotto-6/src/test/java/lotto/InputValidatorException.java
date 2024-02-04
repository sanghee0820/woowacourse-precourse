package lotto;

import lotto.util.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorException {

    @Test
    @DisplayName("예산 예외 테스트")
    public void budgetTest() {
        String budget = "test";
        Assertions.assertThatThrownBy(() -> InputValidator.validateBudget(budget))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
