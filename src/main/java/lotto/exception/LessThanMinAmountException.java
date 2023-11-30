package lotto.exception;

public class LessThanMinAmountException extends IllegalArgumentException {

    public LessThanMinAmountException(Integer minAmount) {
        super(minAmount + "원 이상의 값을 입력하셔야 합니다. 다시 입력해주세요.");
    }
}
