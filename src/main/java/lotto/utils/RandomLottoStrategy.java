package lotto.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static lotto.utils.Constants.*;

public class RandomLottoStrategy implements LottoStrategy {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LottoSize);
    }
}