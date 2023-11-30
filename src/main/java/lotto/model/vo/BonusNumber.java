package lotto.model.vo;

import lotto.exception.NotInRangeException;

public class BonusNumber {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;

    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (!isInRange(number)) {
            throw new NotInRangeException(MIN_NUMBER, MAX_NUMBER);
        }
    }

    private boolean isInRange(Integer number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return true;
        }
        return false;
    }

    public Integer getNumber() {
        return number;
    }
}
