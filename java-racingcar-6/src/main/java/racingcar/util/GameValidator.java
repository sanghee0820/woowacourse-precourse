package racingcar.util;

import java.util.List;
import racingcar.exception.ExcessiveParticipantsNameException;
import racingcar.exception.WrongCountTypeException;

public class GameValidator {

    private static final String isNumeric = "\\d+";
    public static void validateName(List<String> names){
        for(String name : names){
            if(name.length() > 5){
                throw new ExcessiveParticipantsNameException(": from NameValidate");
            }
        }
    }

    public static void validateGameCount(String count){
        if(!count.matches(isNumeric)){
            throw new WrongCountTypeException(" : from GameCountValidate");
        }
    }
}
