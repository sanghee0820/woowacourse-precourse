package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Human;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HumanTest {
    @DisplayName("예산 오류 테스트")
    @Test
    void throwBudgetErrorTest() {
        int budget = 10100;
        assertThatThrownBy(() -> new Human(budget)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 테스트")
    @Test
    void buyLottoTest() {
        int budget = 10000;
        Human human = new Human(budget);
        while (true) {
            if (!human.addLotto
                    (new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))) {
                break;
            }
        }

        assertThat(human.getLottos().size()).isEqualTo(10);
    }

    @DisplayName("로또 구매 출력 테스트")
    @Test
    void printLottoTest() {
        int budget = 10000;
        Human human = new Human(budget);
        while (true) {
            if (!human.addLotto
                    (new Lotto(List.of(1, 2, 3, 4, 5, 6)))) {
                break;
            }
        }
        for (Lotto lotto : human.getLottos()) {
            assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        }
    }
}
