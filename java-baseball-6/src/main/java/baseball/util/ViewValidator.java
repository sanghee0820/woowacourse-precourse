package baseball.util;

import baseball.error.WrongLengthError;
import baseball.error.WrongTypeError;
import baseball.type.GameMenu;
import java.util.ArrayList;
import java.util.List;

public final class ViewValidator {
    public static List<Integer> validateInput(String input) {
        input = checkInputLength(input);
        return checkInputType(input);
    }

    public static GameMenu validateMenu(String menu) {
        menu = checkMenuLength(menu);
        Integer integerTypeMenu = checkMenuType(menu);
        return GameMenu.getMenu(integerTypeMenu);
    }

    private static String checkInputLength(String input) {
        input = input.replaceAll(" ", "");
        if (input.length() != 3) {
            throw new WrongLengthError(": Caused In Input");
        }
        return input;
    }

    private static List<Integer> checkInputType(String input) {
        List<Integer> integerInput = new ArrayList<>(3);
        for (int index = 0; index < 3; index++) {
            char ch = input.charAt(index);
            int numericValue = Character.getNumericValue(ch);

            if (numericValue < 0 || numericValue > 9) {
                throw new WrongTypeError(": Caused in Input");
            }

            integerInput.add(index, numericValue);
        }
        return integerInput;
    }

    private static String checkMenuLength(String input) {
        input = input.replaceAll(" ", "");
        if (input.length() != 1) {
            throw new WrongLengthError(": Caused in Menu");
        }
        return input;
    }

    private static Integer checkMenuType(String input) {
        char ch = input.charAt(0);
        int numericValue = Character.getNumericValue(ch);

        if (numericValue < 0 || numericValue > 9) {
            throw new WrongTypeError(": Caused in InputType");
        }
        return numericValue;
    }
}
