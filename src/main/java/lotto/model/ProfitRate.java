package lotto.model;

import java.util.Map;
import lotto.model.vo.BuyAmount;

public class ProfitRate {

    private final Double rate;

    public ProfitRate(Double rate) {
        this.rate = rate;
    }

    public static ProfitRate create(Map<Rank, Integer> winningResult, BuyAmount buyAmount) {
        long totalPrize = winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        System.out.println(totalPrize);
        System.out.println(buyAmount.getAmount());
        return new ProfitRate((double) (totalPrize / buyAmount.getAmount()));
    }

    public Double getRate() {
        return rate;
    }
}
