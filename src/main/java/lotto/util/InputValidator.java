package lotto.util;

import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateBuyAmount(String buyAmount) {
        if (buyAmount.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(buyAmount)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (winningNumbers.contains(Integer.valueOf(bonusNumber))) {
            throw new IllegalArgumentException();
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
