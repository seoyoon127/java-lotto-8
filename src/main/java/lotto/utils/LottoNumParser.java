package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class LottoNumParser {
    private LottoNumParser() {
    }

    public static List<Integer> parse(String lottoInput) {
        try {
            return Arrays.stream(lottoInput.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_INTEGER_ERROR_MSG);
        }
    }
}
