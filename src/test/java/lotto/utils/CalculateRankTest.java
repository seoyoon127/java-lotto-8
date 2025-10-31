package lotto.utils;

import lotto.domain.enums.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateRankTest {

    List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
    List<Integer> winNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
    int bonusNum = 6;

    @DisplayName("알맞은 순위를 반환하는지 테스트")
    @Test
    void calculateRank_test() {
        LottoRank rank = CalculateRank.calculate(lottoNumbers, winNumbers, bonusNum);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

}