package lotto.service;

import lotto.domain.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;

class InputExceptionHandlerTest {
    private InputView inputView;

    @BeforeEach
    void setup() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("금액 입력 실패 시 재시작")
    @Test
    void lottoCost_test() {
        String invalidInput1 = "1500\n";
        String invalidInput2 = "abc\n";
        String validInput = "3000\n";
        String combinedInput = invalidInput1 + invalidInput2 + validInput;

        setInput(combinedInput);
        assertThat(InputExceptionHandler.lottoCost(inputView).getLottoCost()).isEqualTo(3000);
    }

    @DisplayName("당첨번호 입력 실패 시 재시작")
    @Test
    void winLotto_test() {
        String invalidInput1 = "1,2,3\n";
        String invalidInput2 = "s,1,2,3,4,5\n";
        String validInput = "1,2,3,4,5,6\n";
        String combinedInput = invalidInput1 + invalidInput2 + validInput;

        setInput(combinedInput);
        assertThat(InputExceptionHandler.winLotto(inputView).getLotto()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스번호 입력 실패 시 재시작")
    @Test
    void bonusNum_test() {
        String invalidInput1 = "s\n";
        String invalidInput2 = "6\n";
        String invalidInput3 = "50\n";
        String validInput = "7\n";
        String combinedInput = invalidInput1 + invalidInput2 + invalidInput3 + validInput;

        setInput(combinedInput);
        assertThat(InputExceptionHandler.bonusNum(inputView, new Lotto(List.of(1, 2, 3, 4, 5, 6))).getBonusNum()).isEqualTo(7);
    }

}