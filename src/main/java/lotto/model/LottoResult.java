package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.vo.BonusNumber;

public class LottoResult {

    private final Lotteries lotteries;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoResult(final Lotteries lotteries, final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.lotteries = lotteries;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoResult from(final Lotteries lotteries, final Lotto lotto, final BonusNumber bonusNumber) {
        return new LottoResult(lotteries, lotto, bonusNumber);
    }

    public Map<LottoRank, Integer> getResult() {
        Map<LottoRank, Integer> playerRank = new HashMap<>();

        List<Lotto> playerLotteries = lotteries.getLotteries();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        playerLotteries.forEach(playerLotto ->
                calculateEachLotto(playerRank, winningNumbers, playerLotto));

        return playerRank;
    }

    private void calculateEachLotto(final Map<LottoRank, Integer> playerRank,
                                    final List<Integer> winningNumbers,
                                    final Lotto playerLottery) {
        List<Integer> playerNumbers = playerLottery.getNumbers();
        LottoRank rank = determineRank(countMatchedNumber(winningNumbers, playerNumbers),
                containBonusNumber(bonusNumber, playerNumbers));

        playerRank.put(rank, playerRank.getOrDefault(rank, 0) + 1);
    }

    private LottoRank determineRank(final Integer matchedCount, final boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getMatchedCount().equals(matchedCount) && rank.isIncludeBonus() == hasBonus)
                .findFirst()
                .orElse(LottoRank.NON_RANK);
    }

    private int countMatchedNumber(final List<Integer> winningNumbers, final List<Integer> playerNumbers) {
        return (int) playerNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean containBonusNumber(final BonusNumber bonusNumber, final List<Integer> playerNumbers) {
        Integer number = bonusNumber.number();

        if (playerNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}