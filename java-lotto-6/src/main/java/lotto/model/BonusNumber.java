package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void validate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[Error] BonusNumber 가 범위에 있지 않습니다.");
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
