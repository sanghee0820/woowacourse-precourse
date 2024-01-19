package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.Track;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차량_이동_테스트(){
        RacingCar racingCar = new RacingCar("test");
        racingCar.move();
        assertThat(racingCar.toString()).isEqualTo("test : -");
    }

    @Test
    void 트랙_참여자반환_테스트(){
        List<RacingCar> participants = new ArrayList<>(Arrays.asList(
                new RacingCar("Test1"),
                new RacingCar("Test2"),
                new RacingCar("Test2")
        ));
        Track track = new Track(participants);

        assertThat(track.getParticipants()).isEqualTo(participants);
    }

    @Test
    void 트랙_선두반환_테스트(){
        List<RacingCar> participants = new ArrayList<>(Arrays.asList(
                new RacingCar("Test1"),
                new RacingCar("Test2"),
                new RacingCar("Test2")
        ));
        Track track = new Track(participants);

        participants.get(1).move();
        track.updateWinner();

        assertThat(track.getWinners()).contains(participants.get(1));
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
