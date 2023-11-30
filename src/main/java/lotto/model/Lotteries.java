package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.vo.BonusNumber;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries createLotteries(List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    public Map<Rank, Integer> calculateRank(Lotto winningLotto, BonusNumber bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();

        lotteries.forEach(lotto -> {
            Integer matchedCount = lotto.countMatchedNumber(winningLotto);
            boolean containBonusNumber = lotto.isContain(bonusNumber.getNumber());
            result.merge(Rank.findRank(matchedCount, containBonusNumber), 1, Integer::sum);
        });

        return result;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
