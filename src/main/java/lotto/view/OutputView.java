package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;

import static lotto.utils.Constants.*;

public class OutputView {
    List<LottoRank> displayRanks = List.of(
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST
    );

    public void printLottoSize(int size) {
        System.out.println(size + LOTTOS_SIZE_PRINT_MSG);
    }

    public void printLottos(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printLottoStats(EnumMap<LottoRank, Integer> rankResult, double profitRate) {
        System.out.println(LOTTO_STATS_PRINT_MSG);
        for (LottoRank rank : displayRanks) {
            System.out.println(rank.getOutputMsg() + rankResult.get(rank) + COUNT_MSG);
        }
        System.out.printf((PROFIT_RATE_PRINT_MSG), profitRate);
    }
}
