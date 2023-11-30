package lotto.exception;

public class NonNumericInputException extends IllegalArgumentException {

    public NonNumericInputException() {
        super("입력값에 문자가 포함되어 있습니다. 다시 입력해주세요.");
    }
}
