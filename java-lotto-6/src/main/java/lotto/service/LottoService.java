package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Human;
import lotto.model.Lotto;

public class LottoService {
    private final Human human;

    private final List<Integer> normalNumbers;


    private final Integer bonusNumbers;

    public LottoService(int budget, List<Integer> normalNumbers, Integer bonusNumbers) {
        this.human = new Human(budget);
        this.normalNumbers = normalNumbers;
        this.bonusNumbers = bonusNumbers;
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

}
