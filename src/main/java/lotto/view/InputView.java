package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.LottoNumParser;

import java.util.List;

import static lotto.utils.Constants.*;

public class InputView {
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
