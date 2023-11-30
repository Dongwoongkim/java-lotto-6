package lotto.util;

import java.util.List;
import lotto.exception.ContainDuplicateNumberException;
import lotto.exception.EmptyInputException;
import lotto.exception.NonNumericInputException;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateBuyAmount(String buyAmount) {
        if (buyAmount.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(buyAmount)) {
            throw new NonNumericInputException();
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new EmptyInputException();
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber.isEmpty()) {
            throw new EmptyInputException();
        }
        if (!isNumeric(bonusNumber)) {
            throw new NonNumericInputException();
        }
        if (winningNumbers.contains(Integer.valueOf(bonusNumber))) {
            throw new ContainDuplicateNumberException();
        }
    }

    private static boolean isNumeric(String buyAmount) {
        try {
            Integer.valueOf(buyAmount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
