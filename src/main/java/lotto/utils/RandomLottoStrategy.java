package lotto.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoStrategy implements LottoStrategy {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}