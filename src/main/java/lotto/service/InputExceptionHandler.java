package lotto.service;

import lotto.domain.BonusNum;
import lotto.domain.Lotto;
import lotto.domain.LottoCost;
import lotto.view.InputView;

public class InputExceptionHandler {

    public static LottoCost lottoCost(InputView inputView) {
        while (true) {
            try {
                return new LottoCost(inputView.readLottoCost());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto winLotto(InputView inputView) {
        while (true) {
            try {
                return new Lotto(inputView.readWinLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNum bonusNum(InputView inputView, Lotto winLotto) {
        while (true) {
            try {
                return new BonusNum(inputView.readBonusNum(), winLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
