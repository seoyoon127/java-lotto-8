package lotto.domain;

import static lotto.utils.Constants.*;

public class LottoCost {
    private final int lottoCost;

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
            throw new IllegalArgumentException(COST_INTEGER_ERROR_MSG);
        }
    }

    private void validate(int lottoCost) {
        validateIsPositive(lottoCost);
        validateUnit(lottoCost);
    }

    private void validateIsPositive(int lottoCost) {
        if (lottoCost < 0) {
            throw new IllegalArgumentException(COST_POSITIVE_ERROR_MSG);
        }
    }

    private void validateUnit(int lottoCost) {
        if (lottoCost % COST_UNIT != 0) {
            throw new IllegalArgumentException(COST_UNIT_ERROR_MSG);
        }
    }
}
