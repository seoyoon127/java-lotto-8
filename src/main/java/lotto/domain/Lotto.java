package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int LottoSize = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(new ArrayList<>(numbers));
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers.size());
        validateDuplicate(numbers);
        LottoNumberValidator.validateNumbersRange(numbers);
    }

    private void validateLottoSize(Integer size) {
        if (size != LottoSize) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoSize) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복 번호가 있어선 안 됩니다.");
        }
    }
}
