package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Human;
import lotto.model.Lotto;

public class LottoService {
    private final Human human;

    public LottoService(int budget) {
        this.human = new Human(budget);
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


}
