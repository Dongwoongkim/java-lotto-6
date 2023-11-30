package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBuyLottoNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public void printTicketAmount(Integer quantity) {
        printLine();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLine() {
        System.out.println();
    }

    public void printStatistic(Map<Rank, Integer> winningResult, Double profitRate) {
        printLine();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.getOrDefault(Rank.FIRST, 0) + "개");
        System.out.println(String.format("총 수익률은 %,.1f%%입니다.", profitRate));
    }
}
