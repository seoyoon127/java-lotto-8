package lotto.domain.validator;

import java.util.List;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다.");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }
}
