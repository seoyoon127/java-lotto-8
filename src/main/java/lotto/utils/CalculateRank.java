package lotto.utils;

import lotto.domain.enums.LottoRank;

import java.util.List;

public class CalculateRank {

    private static int lottoCorrect;
    private static boolean bonusCorrect;

    private CalculateRank() {
    }

    private static void compareLotto(List<Integer> lottoNumbers, List<Integer> winLottoNumbers, int bonusNum) {
        lottoCorrect = 0;
        bonusCorrect = false;
        for (Integer num : lottoNumbers) {
            if (winLottoNumbers.contains(num)) {
                lottoCorrect += 1;
            } else if (num == bonusNum) {
                bonusCorrect = true;
            }
        }
    }

    public static LottoRank calculate(List<Integer> lottoNumbers, List<Integer> winLottoNumbers, int bonusNum) {
        compareLotto(lottoNumbers, winLottoNumbers, bonusNum);
        if (lottoCorrect == 6) {
            return LottoRank.FIRST;
        }
        if (lottoCorrect == 5) {
            if (bonusCorrect) {
                return LottoRank.SECOND;
            }
            return LottoRank.THIRD;
        }
        if (lottoCorrect == 4) {
            return LottoRank.FOURTH;
        }
        if (lottoCorrect == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NONE;
    }
}
