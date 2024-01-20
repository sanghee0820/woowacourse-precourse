package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.Track;

public class GameController {
    private Track track;

    public GameController(){
        this.track = new Track();
    }

    public void addParticipant(List<String> participants){
        participants.forEach((name) -> track.addParticipant(new RacingCar(name)));
    }

    public List<RacingCar> getParticipants(){
        return track.getParticipants();
    }

    public void takeStep(){
        for(RacingCar racingCar: track.getParticipants()){
            if(Randoms.pickNumberInRange(0,9) > 4){
                racingCar.move();
            }
        }
    }
}
