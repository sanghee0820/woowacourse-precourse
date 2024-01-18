package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<RacingCar> participants;

    private List<RacingCar> winners;
    public Track(){
        this(new ArrayList<>());
    }

    public Track(final List<RacingCar> participants){
        this.participants = participants;
        this.winners = new ArrayList<>();
    }

    public void addParticipant(final RacingCar racingCar){
        this.participants.add(racingCar);
    }

    public List<RacingCar> getParticipants() {
        return participants;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }

}
