package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.utils.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLotto(numbers);
    }

    private List<Integer> sortLotto(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted;
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
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MSG);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoSize) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR_MSG);
        }
    }
}
