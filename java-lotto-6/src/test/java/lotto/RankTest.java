package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("랭크 반환 테스트")
    @Test
    void getRankTest() {
        List<List<Object>> input = new ArrayList<>(new ArrayList<>());
        input.add(List.of(0, false));
        input.add(List.of(2, false));
        input.add(List.of(3, false));
        input.add(List.of(4, false));
        input.add(List.of(5, false));
        input.add(List.of(5, true));
        input.add(List.of(6, false));

        List<Rank> output = new ArrayList<>(List.of(Rank.NONE_RANK, Rank.NONE_RANK,
                Rank.FIFTH_RANK, Rank.FORTH_RANK
                , Rank.THIRD_RANK, Rank.SECOND_RANK_BONUS, Rank.FIRST_RANK));
        assertThat(input.stream().map((a) -> Rank.getRank((int) a.get(0), (boolean) a.get(1))).toList())
                .isEqualTo(output);
    }

    @DisplayName("랭크 오류 테스트")
    @Test
    void getErrorTest() {
        List<List<Object>> input = new ArrayList<>();
        input.add(List.of(7, true));
        input.add(List.of(-1, false));
        input.add(List.of(-2, true));
        assertThatThrownBy(() -> input.forEach((a) -> Rank.getRank((int) a.get(0), (boolean) a.get(1))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
