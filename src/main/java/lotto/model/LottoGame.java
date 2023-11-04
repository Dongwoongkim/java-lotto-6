package lotto.model;

import lotto.Lotto;
import lotto.vo.BonusNumber;

public class LottoGame {

    private final Player player;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoGame(final Player player, final Lotto winningLotto, final BonusNumber bonusNumber) {
        this.player = player;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

}
