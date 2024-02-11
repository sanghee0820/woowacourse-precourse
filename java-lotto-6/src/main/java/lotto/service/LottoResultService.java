package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.util.LottoComparator;

public class LottoResultService {

    private final LottoResult lottoResult;

    public LottoResultService(List<Integer> normalNumbers, Integer bonusNumber) {
        this.lottoResult = new LottoResult(new Lotto(normalNumbers), new BonusNumber(bonusNumber));
    }

    public Map<Rank, Integer> getResult(List<Lotto> lottos) {
        List<Rank> ranks = lottos.stream().map(lotto ->
                        LottoComparator.compareLotto(lottoResult.getNormalNumber(), lottoResult.getBonusNumber(), lotto))
                .toList();

        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }
}
