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

        // TODO : winningLotto, bonusNumber와 userLotto 비교하여 결과 생성
    }

    private BuyAmount initBuyAmount() {
        while (true) {
            try {
                String buyAmount = inputView.inputBuyAmount();
                InputValidator.validateBuyAmount(buyAmount);
                return new BuyAmount(InputConverter.convertStringToInteger(buyAmount));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
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
                outputView.printMessage(e.getMessage());
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
                outputView.printMessage(e.getMessage());
            }
        }
    }
}
