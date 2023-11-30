package lotto.exception;

public class RemainingChangeException extends IllegalArgumentException {

    public RemainingChangeException(Integer perAmount) {
        super(perAmount + "원 단위의 값을 입력하셔야 합니다.");
    }
}
