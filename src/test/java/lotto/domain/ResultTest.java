package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.utils.LottoStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    static class FixedLottoStrategy implements LottoStrategy {
        @Override
        public List<Integer> generate() {
            return new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        }
    }

    Lottos lottos = new Lottos(2, new FixedLottoStrategy());
    Lotto winLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));
    BonusNum bonusNum = new BonusNum("6", winLotto);


    @DisplayName("알맞은 순위 리스트를 반환하는지 확인")
    @Test
    void ResultOf_test() {
        Result result = new Result(lottos, winLotto, bonusNum);
        assertThat(result.getResult().get(LottoRank.FIRST)).isEqualTo(0);
        assertThat(result.getResult().get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(result.getResult().get(LottoRank.THIRD)).isEqualTo(0);
    }

}