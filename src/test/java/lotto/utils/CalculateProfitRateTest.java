package lotto.utils;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateProfitRateTest {

    EnumMap<LottoRank, Integer> rankResult = new EnumMap<>(LottoRank.class);

    @BeforeEach
    void setup() {
        for (LottoRank rank : LottoRank.values()) {
            rankResult.put(rank, 0);
        }
        rankResult.put(LottoRank.FIFTH, rankResult.get(LottoRank.FIRST) + 1);
    }

    @DisplayName("수익률 계산을 테스트")
    @Test
    void calculateProfitRate_test() {
        double profitRate = CalculateProfitRate.calculate(rankResult, 3);
        assertThat(profitRate).isEqualTo(166.7);
    }

}