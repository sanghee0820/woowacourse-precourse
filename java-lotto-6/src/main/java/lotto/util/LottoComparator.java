package lotto.util;

import java.util.HashSet;
import java.util.Set;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoComparator {

    public static Rank compareLotto(final Lotto normal, final BonusNumber bonus, Lotto lotto) {
        Set<Integer> union = new HashSet<>(normal.getNumbers());
        union.addAll(lotto.getNumbers());
        int normalCnt = 12 - union.size();
        if (normalCnt != 5) {
            return Rank.getRank(normalCnt, false);
        }
        return Rank.getRank(normalCnt, lotto.getNumbers().contains(bonus.getBonusNumber()));
    }
}
