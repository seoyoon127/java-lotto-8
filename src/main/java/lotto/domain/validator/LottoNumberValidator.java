package lotto.domain.validator;

import java.util.List;

import static lotto.utils.Constants.*;

public class LottoNumberValidator {

    private LottoNumberValidator() {
    }

    public static void validateRange(Integer number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }
}
