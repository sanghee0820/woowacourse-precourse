package lotto.model;

public enum Rank {
    FIRST_RANK(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_RANK_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_RANK(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FORTH_RANK(4, false, 50000, "4개 일치 (50,000원)"),
    FIFTH_RANK(3, false, 5000, "3개 일치 (5,000원)"),
    NONE_RANK(0, false, 0, "불일치");

    private final Integer normal;
    private final Boolean bonus;
    private final Integer winningReward;

    private final String desc;

    Rank(int normal, boolean bonus, int winningReward, String desc) {
        this.normal = normal;
        this.bonus = bonus;
        this.winningReward = winningReward;
        this.desc = desc;
    }

    public Integer getWinningReward() {
        return winningReward;
    }

    public String getDesc() {
        return desc;
    }

    public static Rank getRank(int normal, boolean bonus) {
        if (normal <= 2 && normal >= 0) {
            return Rank.NONE_RANK;
        }
        for (Rank rank : Rank.values()) {
            if (rank.normal == normal && rank.bonus == bonus) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }
}
