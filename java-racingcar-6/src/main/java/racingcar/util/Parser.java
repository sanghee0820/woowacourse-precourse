package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parseName(String names){
        List<String> parsedNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
        GameValidator.validateName(parsedNames);
        return parsedNames;
    }

    public static Integer parsCount(String count){
        GameValidator.validateGameCount(count);
        return Integer.valueOf(count);
    }
}
