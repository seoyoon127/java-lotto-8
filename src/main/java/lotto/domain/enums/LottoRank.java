package lotto.domain.enums;

public enum LottoRank {
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, "4개 일치 (50,000원) - "),
    FIFTH(5000, "3개 일치 (5,000원) - "),
    NONE(0, "일치하지 않음");

    private final int prizeCost;
    private final String outputMsg;

    LottoRank(int prizeCost, String outputMsg) {
        this.prizeCost = prizeCost;
        this.outputMsg = outputMsg;
    }

    public int getPrizeCost() {
        return prizeCost;
    }

    public String getOutputMsg() {
        return outputMsg;
    }
}
