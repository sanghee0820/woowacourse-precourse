package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoComparator {

    public static Rank compareLotto(final List<Integer> normal, final int bonus, Lotto lotto) {
        Set<Integer> union = new HashSet<>(normal);
        union.addAll(lotto.getNumbers());
        int normalCnt = 12 - union.size();
        if (normalCnt != 5) {
            return Rank.getRank(normalCnt, false);
        }
        return Rank.getRank(normalCnt, lotto.getNumbers().contains(bonus));
    }
}
