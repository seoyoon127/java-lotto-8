package lotto.domain;

import lotto.utils.LottoStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    static class FixedLottoStrategy implements LottoStrategy {
        @Override
        public List<Integer> generate() {
            return new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        }
    }

    FixedLottoStrategy fixedLottoStrategy = new FixedLottoStrategy();

    @DisplayName("개수에 맞는 로또 생성 여부 확인")
    @Test
    void makeLotto_test() {
        Lottos lottos = new Lottos(2, fixedLottoStrategy);
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

}