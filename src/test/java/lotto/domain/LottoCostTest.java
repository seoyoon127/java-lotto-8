package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.utils.Constants.*;

class LottoCostTest {

    @DisplayName("로또 금액이 양수가 아닐 시 예외가 발생한다.")
    @Test
    void validateIsPositive_test() {
        assertThatThrownBy(() -> new LottoCost("-12000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COST_POSITIVE_ERROR_MSG);
    }

    @DisplayName("로또 금액이 1000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void validateUnit_test() {
        assertThatThrownBy(() -> new LottoCost("12345"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COST_UNIT_ERROR_MSG);
    }

    @DisplayName("구매 금액이 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void validateString_test() {
        assertThatThrownBy(() -> new LottoCost("돈돈"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COST_INTEGER_ERROR_MSG);
    }
}