package lotto.exception;

public class InvalidLottoSizeException extends IllegalArgumentException {

    public InvalidLottoSizeException(Integer lottoSize) {
        super(lottoSize + "개의 정수를 입력하셔야 합니다. 다시 입력해주세요.");
    }
}
