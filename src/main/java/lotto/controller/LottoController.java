package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.NumberGenerator;
import lotto.model.ProfitRate;
import lotto.model.RandomNumberGenerator;
import lotto.model.Rank;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.BuyAmount;
import lotto.model.vo.Ticket;
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
        Ticket ticket = initTicket(buyAmount);
        Lotteries buyLotteries = initBuyLotteries(ticket, new RandomNumberGenerator());

        showBuyLottoInfo(ticket, buyLotteries);

        Lotto winningLotto = initWinningLotto();
        BonusNumber bonusNumber = initBonusNumber(winningLotto.getNumbers());

        Map<Rank, Integer> winningResult = buyLotteries.calculateRank(winningLotto, bonusNumber);
        ProfitRate profitRate = ProfitRate.create(winningResult, buyAmount);
        showStatistic(winningResult, profitRate);
    }

    private void showStatistic(Map<Rank, Integer> winningResult, ProfitRate profitRate) {
        outputView.printStatistic(winningResult, profitRate.getRate());
    }

    private void showBuyLottoInfo(Ticket ticket, Lotteries buyLotteries) {
        outputView.printTicketAmount(ticket.getQuantity());

        buyLotteries.getLotteries().forEach(
                lotto -> outputView.printBuyLottoNumber(lotto.getNumbers())
        );
    }

    private Ticket initTicket(BuyAmount buyAmount) {
        return new Ticket(buyAmount.getPerAmount());
    }

    private Lotteries initBuyLotteries(Ticket ticket, NumberGenerator numberGenerator) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int count = 0; count < ticket.getQuantity(); count++) {
            Lotto randomLotto = Lotto.createRandomLotto(numberGenerator);
            lotteries.add(randomLotto);
        }
        return Lotteries.createLotteries(lotteries);
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
