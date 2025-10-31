package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.LottoNumParser;

import java.util.List;

public class InputView {
    static final String COST_INPUT_MSG = "구입금액을 입력해 주세요.";
    static final String WIN_LOTTO_INPUT_MSG = "\n당첨 번호를 입력해 주세요.";
    static final String BONUS_NUM_INPUT_MSG = "\n보너스 번호를 입력해 주세요.";

    public String readLottoCost() {
        System.out.println(COST_INPUT_MSG);
        return Console.readLine();
    }

    public List<Integer> readWinLotto() {
        System.out.println(WIN_LOTTO_INPUT_MSG);
        return LottoNumParser.parse(Console.readLine());
    }

    public String readBonusNum() {
        System.out.println(BONUS_NUM_INPUT_MSG);
        return Console.readLine();
    }
}
