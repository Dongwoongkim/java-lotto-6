package lotto.exception;

public class NotInRangeException extends IllegalArgumentException {

    public NotInRangeException(Integer minNumber, Integer maxNumber) {
        super(String.format("%d ~ %d 사이의 값을 입력하셔야 합니다.", minNumber, maxNumber));
    }
}
