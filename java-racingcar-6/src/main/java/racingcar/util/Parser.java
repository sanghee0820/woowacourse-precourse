package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<String> parseName(String names){
        List<String> parsedNames = Arrays.stream(names.split(","))
                .map(String::trim)
                .toList();
        return parsedNames;
    }

    public static Integer parsCount(String count){
        return Integer.valueOf(count);
    }
}
