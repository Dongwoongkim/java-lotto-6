package lotto.model.vo;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    private void validate(Integer number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInRange(Integer number) {
        if (number >= 1 && number <= 45) {
            return true;
        }
        return false;
    }
}
