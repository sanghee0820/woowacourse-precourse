package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.LottoComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 확인 테스트")
    @Test
    void compareLottoNumTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<List<Integer>> normalNumbers = new ArrayList<>();
        normalNumbers.add(List.of(1, 2, 3, 9, 10, 11));
        normalNumbers.add(List.of(1, 2, 3, 4, 10, 11));
        normalNumbers.add(List.of(1, 2, 3, 4, 5, 11));
        normalNumbers.add(List.of(1, 2, 3, 4, 5, 8));

        List<Integer> bonusNumbers = List.of(15, 5, 10, 11);
        List<Rank> result = List.of(Rank.FIFTH_RANK, Rank.FORTH_RANK, Rank.THIRD_RANK, Rank.FIRST_RANK);
        for (int i = 0; i < normalNumbers.size(); i++) {
            assertThat(LottoComparator.compareLotto(new Lotto(normalNumbers.get(i)),
                    new BonusNumber(bonusNumbers.get(i)), lotto)).isEqualTo(
                    result.get(i));
        }

    }
}