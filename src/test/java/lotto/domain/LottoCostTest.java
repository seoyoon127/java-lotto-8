package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCostTest {

    @DisplayName("로또 금액이 양수가 아닐 시 예외가 발생한다.")
    @Test
    void validateIsPositive_test() {
        assertThatThrownBy(() -> new LottoCost("-12000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 양수여야 합니다.");
    }

    @DisplayName("로또 금액이 1000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void validateUnit_test() {
        assertThatThrownBy(() -> new LottoCost("12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1000 단위여야 합니다.");
    }

    @DisplayName("구매 금액이 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void validateString_test() {
        assertThatThrownBy(() -> new LottoCost("돈돈"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 숫자여야 합니다.");
    }
}