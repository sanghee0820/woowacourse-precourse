package lotto.controller;

import java.util.List;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoService lottoService;
    private LottoResultService lottoResultService;

    public void run() {
        setLottoService();
        setNumbers();
        lottoService.buyLotto();
        OutputView.lottoDesc(lottoService.getLottos());
        resultDesc();
    }

    private void setLottoService() {
        this.lottoService = new LottoService(getBudget());
    }

    private void setNumbers() {
        this.lottoResultService = new LottoResultService(this.getNormalNumbers(), this.getBonusNumbers());
    }

    private int getBudget() {
        int budget = 0;
        while (true) {
            try {
                OutputView.budgetDesc();
                budget = InputValidator.validateBudget(InputView.getBudget());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return budget;
    }


    private List<Integer> getNormalNumbers() {
        List<Integer> normalNumbers;
        while (true) {
            try {
                OutputView.normalNumberDesc();
                normalNumbers = InputValidator.validateNormalNumbers(InputView.getNormalNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return normalNumbers;
    }

    private int getBonusNumbers() {
        OutputView.bonusNumberDesc();
        return InputValidator.validateBonusNumber(InputView.getBonusNumbers());
    }

    private void resultDesc() {

        OutputView.rankDesc(lottoResultService.getResult(lottoService.getLottos()), lottoService.getBudget());
    }
}
