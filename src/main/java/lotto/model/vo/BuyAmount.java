package lotto.model.vo;

public class BuyAmount {

    private static final Integer MIN_AMOUNT = 1000;
    private final Integer amount;

    public BuyAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (isLessThanMinAmount(amount)) {
            throw new IllegalArgumentException();
        }
        if (isRemainingChange(amount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRemainingChange(Integer amount) {
        if (amount % 1000 != 0) {
            return true;
        }
        return false;
    }

    private boolean isLessThanMinAmount(Integer amount) {
        return amount < MIN_AMOUNT;
    }
}
