package lotto.model;

public class LottoResult {
    private final Lotto normalNumber;
    private final BonusNumber bonusNumber;

    public LottoResult(Lotto normalNumber, BonusNumber bonusNumber) {
        validate(normalNumber, bonusNumber);
        this.normalNumber = normalNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getNormalNumber() {
        return normalNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto normalNumber, BonusNumber bonusNumber) {
        if (normalNumber.getNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[Error] NormalNumber에 BonusNumber이 중복됩니다.");
        }
    }
}
