package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    private static final String DELIMITER = ",";

    private InputConverter() {
    }

    public static Integer convertStringToInteger(String input) {
        return Integer.valueOf(input);
    }

    public static List<Integer> convertStringToIntegerListByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
