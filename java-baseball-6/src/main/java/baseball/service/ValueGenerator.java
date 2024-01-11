package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ValueGenerator {
    public static List<Integer> getRandomValue(){
        List<Integer> value = new ArrayList<>();
        while (value.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!value.contains(randomNumber)) {
                value.add(randomNumber);
            }
        }

        return value;
    }
}
