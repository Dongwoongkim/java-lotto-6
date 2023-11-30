package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ContainDuplicateNumberException;
import lotto.exception.InvalidLottoSizeException;
import lotto.exception.NotInRangeException;

public class Lotto {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createWinningLotto(List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public static Lotto createRandomLotto(NumberGenerator numberGenerator) {
        List<Integer> pickedNumbers = numberGenerator.pickNumbers();
        return new Lotto(pickedNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoSizeException(LOTTO_SIZE);
        }
        if (isContainDuplicateNumber(numbers)) {
            throw new ContainDuplicateNumberException();
        }
        if (isNotInRange(numbers)) {
            throw new NotInRangeException(MIN_NUMBER, MAX_NUMBER);
        }
    }

    private boolean isNotInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
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
