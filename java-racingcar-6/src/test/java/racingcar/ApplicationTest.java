package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExcessiveParticipantsNameException;
import racingcar.exception.WrongCountTypeException;
import racingcar.service.GameService;
import racingcar.model.RacingCar;
import racingcar.model.Track;
import racingcar.util.GameValidator;
import racingcar.util.Parser;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
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
    @Test
    void 게임컨트롤러_참가자_반환_테스트(){
        List<String> participantsName = new ArrayList<>(Arrays.asList(
                "Test1",
                "Test2",
                "Test3"
        ));
        List<String> result = new ArrayList<>(Arrays.asList(
                "Test1 : ",
                "Test2 : ",
                "Test3 : "
        ));
        GameService gameService = new GameService();
        gameService.addParticipant(participantsName);
        assertThat(gameService.getParticipants().stream()
                .map(RacingCar::toString)
                .collect(Collectors.toList()))
                .isEqualTo(result);

    }

    @Test
    @RepeatedTest(100)
    void 게임컨트롤러_단계_반환_테스트(){
        List<String> participantsName = new ArrayList<>(Arrays.asList(
                "Test1"
        ));
        List<String> result = new ArrayList<>(Arrays.asList(
                "Test1 : ",
                "Test1 : -"
        ));
        GameService gameService = new GameService();
        gameService.addParticipant(participantsName);
        gameService.takeStep();
        assertThat(result).contains(gameService.getParticipants().get(0).toString());
    }

    @Test
    void 이름_파싱_테스트(){
        String names = "test1, test2, test3";
        List<String> parsedNames = new ArrayList<>(Arrays.asList(
                "test1","test2","test3"
        ));
        assertThat(Parser.parseName(names)).isEqualTo(parsedNames);
    }

    @Test
    void 잘못된_이름_길이_확인_테스트(){
        List<String> parsedNames = new ArrayList<>(Arrays.asList(
                "test1","test255","test3"
        ));
        assertThatThrownBy(() -> GameValidator.validateName(parsedNames)).isInstanceOf(ExcessiveParticipantsNameException.class);
    }

    @Test
    void 올바른_이름_파싱_테스트(){
        List<String> parsedNames = new ArrayList<>(Arrays.asList(
                "test1","test2","test3"
        ));
        assertThatCode(() -> GameValidator.validateName(parsedNames))
                .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_숫자형_테스트(){
        List<String> counts = Arrays.asList(
                "k", "-", "A", "ㅁ", "안"
        );
        assertThatThrownBy(() -> counts
                .forEach(GameValidator::validateGameCount))
                .isInstanceOf(WrongCountTypeException.class);
    }

    @Test
    void 숫자형_확인_테스트(){
        List<String> counts = Arrays.asList(
                "1", "2", "123", "55", "4"
        );
        assertThatCode(() -> counts
                .forEach(GameValidator::validateGameCount))
                .doesNotThrowAnyException();
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
