package lotto.view;

import java.util.Collections;
import java.util.List;

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
}
