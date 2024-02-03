package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private final List<Lotto> lottos;
    private final int budget;

    public Human(int budget) {
        this.lottos = new ArrayList<>();
        validateBudget(budget);
        this.budget = budget;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getBudget() {
        return budget;
    }

    private void validateBudget(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean addLotto(Lotto lotto) {
        if (checkLottosSize()) {
            this.lottos.add(lotto);
            return true;
        }
        return false;
    }

    private boolean checkLottosSize() {
        return lottos.size() < budget / 1000;
    }

}
