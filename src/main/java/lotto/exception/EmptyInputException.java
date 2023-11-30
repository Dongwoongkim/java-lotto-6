package lotto.exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super("빈 값은 허용되지 않습니다. 다시 입력해주세요.");
    }
}
