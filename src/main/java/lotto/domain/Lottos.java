package lotto.domain;

import lotto.utils.LottoStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int size, LottoStrategy lottoStrategy) {
        lottos = makeLottos(size, lottoStrategy);
    }

    private List<Lotto> makeLottos(int size, LottoStrategy lottoStrategy) {
        List<Lotto> newLottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = new Lotto(lottoStrategy.generate());
            newLottos.add(lotto);
        }
        return newLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
