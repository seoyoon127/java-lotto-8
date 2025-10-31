package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.List;

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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void valdiate(int bonusNum) {
        LottoNumberValidator.validateRange(bonusNum);
        validateDuplicate(bonusNum);
    }

    private void validateDuplicate(int bonusNum) {
        if (winNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹쳐서는 안 됩니다.");
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
