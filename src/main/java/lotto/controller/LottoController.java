package lotto.controller;

import lotto.domain.*;
import lotto.service.InputExceptionHandler;
import lotto.utils.RandomLottoStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoCost lottoCost;
    private Lotto winLotto;
    private Lottos lottos;
    private BonusNum bonusNum;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        readLottoCost();
        createLottos();
        readWinLotto();
        createStats();
    }

    private void readLottoCost() {
        lottoCost = InputExceptionHandler.lottoCost(inputView);
        System.out.println();
    }

    private void createLottos() {
        outputView.printLottoSize(lottoCost.getLottoUnit());
        lottos = new Lottos(lottoCost.getLottoUnit(), new RandomLottoStrategy());
        outputView.printLottos(lottos.getLottos());
    }

    private void readWinLotto() {
        winLotto = InputExceptionHandler.winLotto(inputView);
        bonusNum = InputExceptionHandler.bonusNum(inputView, winLotto);
    }

    private void createStats() {
        Result result = new Result(lottos, winLotto, bonusNum);
        outputView.printLottoStats(result.getResult(), result.getProfitRate());
    }
}
