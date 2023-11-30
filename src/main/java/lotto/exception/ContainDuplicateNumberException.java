package lotto.exception;

public class ContainDuplicateNumberException extends IllegalArgumentException {

    public ContainDuplicateNumberException() {
        super("중복된 숫자가 포함되어 있습니다. 다시 입력해주세요.");
    }
}
