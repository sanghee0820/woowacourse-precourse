package racingcar.exception;

public class ExcessiveParticipantsNameException extends IllegalArgumentException{


    public ExcessiveParticipantsNameException(){
        this("");
    }
    public ExcessiveParticipantsNameException(String from){
        super("ExcessiveParticipantsNameException : ".concat(from));
    }
}
