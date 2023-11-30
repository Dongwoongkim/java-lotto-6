package lotto.model.vo;

import lotto.exception.LessThanMinAmountException;
import lotto.exception.RemainingChangeException;

public class BuyAmount {

    private static final Integer MIN_AMOUNT = 1000;

    private final Integer amount;

    public BuyAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (isLessThanMinAmount(amount)) {
            throw new LessThanMinAmountException(MIN_AMOUNT);
        }
        if (isRemainingChange(amount)) {
            throw new RemainingChangeException(MIN_AMOUNT);
        }
    }

    private boolean isRemainingChange(Integer amount) {
        if (amount % MIN_AMOUNT != 0) {
            return true;
        }
        return false;
    }

    private boolean isLessThanMinAmount(Integer amount) {
        return amount < MIN_AMOUNT;
    }

    public Integer getPerAmount() {
        return amount / MIN_AMOUNT;
    }
}
