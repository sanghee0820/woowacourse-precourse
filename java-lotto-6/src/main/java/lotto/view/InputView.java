package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getBudget() {
        return Console.readLine();
    }

    public static String getNormalNumbers() {
        return Console.readLine();
    }

    public static String getBonusNumbers() {
        return Console.readLine();
    }
}
