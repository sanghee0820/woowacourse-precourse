package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    private static final String GET_BUDGET_DESC = "구입금액을 입력해 주세요.";

    private static final String BOUGHT_LOTTO_DESC = "\n%d개를 구매했습니다.\n";
    private static final String NORMAL_NUMBERS_DESC = "\n당첨 번호를 입력해 주세요.";

    private static final String BONUS_NUMBER_DESC = "\n보너스 번호를 입력해 주세요.";
    private static final String RESULT_DESC = " \n당첨 통계\n---";
    private static final String RETURN_RATE_DESC = "총 수익률은 %.1f%%입니다.";

    public static void budgetDesc() {
        System.out.println(GET_BUDGET_DESC);
    }

    public static void lottoDesc(List<Lotto> lottos) {
        System.out.printf(BOUGHT_LOTTO_DESC, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void normalNumberDesc() {
        System.out.println(NORMAL_NUMBERS_DESC);
    }

    public static void bonusNumberDesc() {
        System.out.println(BONUS_NUMBER_DESC);
    }

    public static void rankDesc(Map<Rank, Integer> ranks, int budget) {
        System.out.println(RESULT_DESC);
        int totalReturn = 0;
        List<Rank> rankInfo = Arrays.asList(Rank.values());
        Collections.reverse(rankInfo);
        for (Rank rank : rankInfo) {
            if (!rank.equals(Rank.NONE_RANK)) {
                System.out.printf(rank.getDesc() + " - %d개\n", ranks.get(rank));
            }
            if (ranks.get(rank) != 0) {
                totalReturn += rank.getWinningReward();
            }
        }
        System.out.printf(RETURN_RATE_DESC, ((double) totalReturn / budget) * 100);
    }
}
