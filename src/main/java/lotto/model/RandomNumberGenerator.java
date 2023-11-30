package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer NUMBER_SIZE = 6;

    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
    }
}
