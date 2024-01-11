package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.service.ValueGenerator;
import baseball.type.Result;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @RepeatedTest(3000)
    void 랜덤값_생성_테스트() {
        Set<Integer> randomSet = new HashSet<>(ValueGenerator.getRandomValue());
        assertThat(randomSet.size()).isEqualTo(3);
    }

    @Test
    void 결과값_생성_테스트() {
        List<List<Object>> inputs = Arrays.asList(
                Arrays.asList(0, 0, "낫싱"),
                Arrays.asList(1, 0, "1볼"), Arrays.asList(2, 0, "2볼"), Arrays.asList(3, 0, "3볼"),
                Arrays.asList(0, 1, "1스트라이크"), Arrays.asList(1, 1, "1볼 1스트라이크"),
                Arrays.asList(2, 1, "2볼 1스트라이크"),
                Arrays.asList(0, 2, "2스트라이크"), Arrays.asList(0, 3, "3스트라이크")
        );

        for (List<Object> input : inputs) {
            assertThat(Result.getType((int) input.get(0), (int) input.get(1)).toString())
                    .isEqualTo((String) input.get(2));
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
