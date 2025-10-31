package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 50})
    void lottoRange_test(int outRangeNum) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, outRangeNum)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 정렬되는지 확인한다.")
    @Test
    void lottoSort_test() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(6, 5, 4, 3, 2, 1)));
        assertThat(lotto.getLotto()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
