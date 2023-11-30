package lotto.model;

public enum Rank {

    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final Integer matchedCount;
    private final boolean requiredContainBonusNumber;
    private final Long prizeMoney;


    Rank(Integer matchedCount, boolean requiredContainBonusNumber, Long prizeMoney) {
        this.matchedCount = matchedCount;
        this.requiredContainBonusNumber = requiredContainBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Rank findRank(Integer matchedCount, boolean containBonusNumber) {
        for (Rank rank : values()) {
            if (rank.matchedCount.equals(matchedCount) && rank.requiredContainBonusNumber == containBonusNumber) {
                return rank;
            }
        }
        return NONE;
    }
}
