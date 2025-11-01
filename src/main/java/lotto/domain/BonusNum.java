package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.List;

import static lotto.utils.Constants.*;

public class BonusNum {
    private int bonusNum;
    private List<Integer> winNumbers;

    public BonusNum(String bonusNum, Lotto winLotto) {
        winNumbers = winLotto.getLotto();
        int convertedBonusNum = convertToInt(bonusNum);
        valdiate(convertedBonusNum);
        this.bonusNum = convertedBonusNum;
    }

    private int convertToInt(String bonusNum) {
        try {
            return Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_INTEGER_ERROR_MSG);
        }
    }

    private void valdiate(int bonusNum) {
        LottoNumberValidator.validateRange(bonusNum);
        validateDuplicate(bonusNum);
    }

    private void validateDuplicate(int bonusNum) {
        if (winNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR_MSG);
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
