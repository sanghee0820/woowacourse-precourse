package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Human;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.LottoComparator;

public class LottoService {
    private final Human human;

    private final List<Integer> normalNumbers;

    private final Integer bonusNumber;

    public LottoService(int budget, List<Integer> normalNumbers, Integer bonusNumber) {
        this.human = new Human(budget);
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
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

    public List<Lotto> getLottos() {
        return human.getLottos();
    }

    public List<Rank> getResult() {
        return human.getLottos().stream().map(lotto ->
                LottoComparator.compareLotto(normalNumbers, bonusNumber, lotto)).toList();
    }

}
