package lotto.utils;

public class Constants {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    public static final int LottoSize = 6;
    public static final int COST_UNIT = 1000;
    public static final String delimiter = ",";

    //범위 관련
    public static final String RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다.";

    //보너스 번호 관련
    public static final String BONUS_INTEGER_ERROR_MSG = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_DUPLICATE_ERROR_MSG = "[ERROR] 보너스 번호는 당첨 번호와 겹쳐서는 안 됩니다.";

    //로또 번호 관련
    public static final String LOTTO_INTEGER_ERROR_MSG = "[ERROR] 로또 번호는 숫자로 작성해야 합니다.";
    public static final String LOTTO_SIZE_ERROR_MSG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_DUPLICATE_ERROR_MSG = "[ERROR] 로또에 중복 번호가 있어선 안 됩니다.";

    //구매 금액 관련
    public static final String COST_INTEGER_ERROR_MSG = "[ERROR] 구매 금액은 숫자여야 합니다.";
    public static final String COST_POSITIVE_ERROR_MSG = "[ERROR] 구입 금액은 양수여야 합니다.";
    public static final String COST_UNIT_ERROR_MSG = "[ERROR] 구매 금액은 1000 단위여야 합니다.";

    //입력 관련
    public static final String COST_INPUT_MSG = "구입금액을 입력해 주세요.";
    public static final String WIN_LOTTO_INPUT_MSG = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_INPUT_MSG = "\n보너스 번호를 입력해 주세요.";

    //출력 관련
    public static final String LOTTOS_SIZE_PRINT_MSG = "개를 구매했습니다.";
    public static final String LOTTO_STATS_PRINT_MSG = "\n당첨 통계\n---";
    public static final String COUNT_MSG = "개";
    public static final String PROFIT_RATE_PRINT_MSG = "총 수익률은 %s%%입니다.";
}
