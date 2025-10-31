package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumTest {

    @DisplayName("보너스 번호 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "50"})
    void bonusRange_test(String outRangeNum) {
        assertThatThrownBy(() -> new BonusNum(outRangeNum, new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 겹칠 시 예외가 발생한다.")
    @Test
    void validateDuplicate_test() {
        assertThatThrownBy(() -> new BonusNum("1", new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 겹쳐서는 안 됩니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void validateString_test() {
        assertThatThrownBy(() -> new BonusNum("@", new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }
}