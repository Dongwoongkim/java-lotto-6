package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isContainDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isNotInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }

    private boolean isContainDuplicateNumber(List<Integer> numbers) {
        Set<Integer> distinct = new HashSet<>(numbers);
        return distinct.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
