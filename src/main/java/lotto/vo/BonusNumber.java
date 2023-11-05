package lotto.vo;

import static lotto.constant.ErrorMessage.LARGER_THAN_MAX_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.constant.LottoInfo.LOTTO_MAX_NUMBER;

import lotto.constant.LottoInfo;

public record BonusNumber(Integer number) {

    public BonusNumber {
        validateNumber(number);
    }

    private void validateNumber(final Integer number) {
        if (isLargerThanMaxNumber(number)) {
            throw new IllegalArgumentException(LARGER_THAN_MAX_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
        if (isLessThanMinNumber(number)) {
            throw new IllegalArgumentException(LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isLessThanMinNumber(final Integer number) {
        return number < LottoInfo.LOTTO_MIN_NUMBER.getValue();
    }

    private boolean isLargerThanMaxNumber(final Integer number) {
        return number > LOTTO_MAX_NUMBER.getValue();
    }
}
