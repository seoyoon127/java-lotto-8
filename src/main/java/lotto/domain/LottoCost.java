package lotto.domain;

public class LottoCost {
    private int lottoCost;
    private static final int COST_UNIT = 1000;

    public LottoCost(int lottoCost) {
        validate(lottoCost);
        this.lottoCost = lottoCost;
    }

    public int getLottoUnit() {
        return lottoCost % COST_UNIT;
    }

    public int getLottoCost() {
        return lottoCost;
    }

    private void validate(int lottoCost) {
        validateIsPositive(lottoCost);
        validateUnit(lottoCost);
    }

    private void validateIsPositive(int lottoCost) {
        if (lottoCost < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    private void validateUnit(int lottoCost) {
        if (lottoCost % COST_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000 단위여야 합니다.");
        }
    }
}
