package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class OutputView {
    private final String RESULT_OUTPUT = "실행";

    private final String FINAL_OUTPUT = "최종 우승자 : ";

    public void printStepStart(){
        System.out.println(RESULT_OUTPUT);
    }
    public void printStepResult(List<RacingCar> participants){
        participants.forEach(System.out::println);
        System.out.println();
    }

    public void printResult(List<RacingCar> participants){

        System.out.print(FINAL_OUTPUT);
        String result = participants.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}
