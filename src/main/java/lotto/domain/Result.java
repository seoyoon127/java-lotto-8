package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.utils.CalculateProfitRate;
import lotto.utils.CalculateRank;

import java.util.EnumMap;

public class Result {
    private EnumMap<LottoRank, Integer> rankResult;
    private double profitRate;

    public Result(Lottos lottos, Lotto winLotto, BonusNum bonusNum) {
        rankResultInitialize();
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = CalculateRank.calculate(lotto.getLotto(), winLotto.getLotto(), bonusNum.getBonusNum());
            increaseCount(rank);
        }
        profitRate = CalculateProfitRate.calculate(rankResult, lottos.getLottos().size());
    }

    private void rankResultInitialize() {
        rankResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }
        profitRate = 0;
    }

    public EnumMap<LottoRank, Integer> getResult() {
        return rankResult;
    }

    private void increaseCount(LottoRank lottoRank) {
        rankResult.put(lottoRank, rankResult.get(lottoRank) + 1);
    }

    public double getProfitRate() {
        return profitRate;
    }

}