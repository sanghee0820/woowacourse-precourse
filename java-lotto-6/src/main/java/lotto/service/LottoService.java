package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
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

    public List<Rank> getResult() {
        return human.getLottos().stream().map(lotto ->
                LottoComparator.compareLotto(normalNumbers, bonusNumber, lotto)).toList();
    }

}
