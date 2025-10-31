package lotto.utils;

import lotto.domain.enums.LottoRank;

import java.util.EnumMap;

public class CalculateProfitRate {

    private CalculateProfitRate() {
    }

    public static double calculate(EnumMap<LottoRank, Integer> rankResult, int size) {
        int lottoCost = (size * 1000);
        int profit = calculateProfit(rankResult);
        double profitRate = (double) profit / lottoCost * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

    public static int calculateProfit(EnumMap<LottoRank, Integer> rankResult) {
        int sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += rank.getPrizeCost() * rankResult.get(rank);
        }
        return sum;
    }
}
