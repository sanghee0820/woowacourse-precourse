package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Human;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.LottoComparator;

public class LottoService {
    private final Human human;

    private List<Integer> normalNumbers;

    private Integer bonusNumber;

    public LottoService(int budget) {
        this.human = new Human(budget);
    }

    public void setNormalNumbers(List<Integer> normalNumbers) {
        this.normalNumbers = normalNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottos() {
        return human.getLottos();
    }

    public Integer getBudget() {
        return human.getBudget();
    }

    public void buyLotto() {
        while (true) {
            if (!human.addLotto(
                    new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            )) {
                break;
            }
        }
    }

    public Map<Rank, Integer> getResult() {
        List<Rank> ranks = human.getLottos().stream().map(lotto ->
                LottoComparator.compareLotto(normalNumbers, bonusNumber, lotto)).toList();

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
