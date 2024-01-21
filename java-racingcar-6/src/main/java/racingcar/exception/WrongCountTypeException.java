package racingcar.exception;

public class WrongCountTypeException extends IllegalArgumentException{

    public WrongCountTypeException(){
        this("");
    }

    public WrongCountTypeException(String from){
        super("WrongCountTypeException : ".concat(from));
    }
}
