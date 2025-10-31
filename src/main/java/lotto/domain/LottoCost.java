package lotto.domain;

public class LottoCost {
    private int lottoCost;
    private static final int COST_UNIT = 1000;

    public LottoCost(String lottoCost) {
        int convertedLottoCost = convertToInt(lottoCost);
        validate(convertedLottoCost);
        this.lottoCost = convertedLottoCost;
    }

    public int getLottoUnit() {
        return lottoCost / COST_UNIT;
    }

    public int getLottoCost() {
        return lottoCost;
    }

    private int convertToInt(String bonusNum) {
        try {
            return Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
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
