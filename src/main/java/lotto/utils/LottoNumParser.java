package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumParser {
    private static String delimiter = ",";

    private LottoNumParser() {
    }

    public static List<Integer> parse(String lottoInput) {
        try {
            return Arrays.stream(lottoInput.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 작성해야 합니다.");
        }
    }
}
