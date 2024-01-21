package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.Track;

public class GameService {
    private final Track track;

    public GameService(){
        this.track = new Track();
    }

    public void addParticipant(List<String> participants){
        participants.forEach((name) -> track.addParticipant(new RacingCar(name)));
    }

    public List<RacingCar> getParticipants(){
        return track.getParticipants();
    }

    public List<RacingCar> getWinner(){
        track.updateWinner();
        return track.getWinners();
    }

    public void takeStep(){
        for(RacingCar racingCar: track.getParticipants()){
            if(Randoms.pickNumberInRange(0,9) > 3){
                racingCar.move();
            }
        }
    }
}
