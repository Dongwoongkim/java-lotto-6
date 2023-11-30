package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.BuyAmount;
import lotto.util.InputConverter;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BuyAmount buyAmount = initBuyAmount();
        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto.getNumbers());
    }

    private BuyAmount initBuyAmount() {
        while (true) {
            try {
                String buyAmount = inputView.inputBuyAmount();
                InputValidator.validateBuyAmount(buyAmount);
                return new BuyAmount(InputConverter.convertStringToInteger(buyAmount));
            } catch (IllegalArgumentException e) {
                // TODO : 에러 메시지 출력
            }
        }
    }

    private Lotto initWinningLotto() {
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                InputValidator.validateWinningNumbers(winningNumbers);
                return Lotto.createWinningLotto(InputConverter.convertStringToIntegerListByDelimiter(winningNumbers));
            } catch (IllegalArgumentException e) {
                // TODO : 에러 메시지 출력
            }
        }
    }

    private BonusNumber initBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumber = inputView.inputBonusNumber();
                InputValidator.validateBonusNumber(bonusNumber, winningNumbers);
                return new BonusNumber(InputConverter.convertStringToInteger(bonusNumber));
            } catch (IllegalArgumentException e) {
                // TODO : 에러 메시지 출력
            }
        }
    }
}
