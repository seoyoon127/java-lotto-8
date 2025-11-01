package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.utils.Constants.*;

class LottoNumParserTest {

    @DisplayName("로또 번호가 숫자가 아니면 오류가 발생한다.")
    @Test
    void InputLottoNotInteger_test() {
        assertThatThrownBy(() -> LottoNumParser.parse("로,또,12,3,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_INTEGER_ERROR_MSG);
    }

    @DisplayName("로또 번호를 리스트로 파싱한다.")
    @Test
    void lottoInputParse_test() {
        assertThat(LottoNumParser.parse("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}