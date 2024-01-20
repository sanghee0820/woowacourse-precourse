package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String COUNT_INPUT = "시도할 회수는 몇회인가요?";

    public String getName(){
        System.out.println(NAME_INPUT);
        return Console.readLine();
    }

    public String getCount(){
        System.out.println(COUNT_INPUT);
        return Console.readLine();
    }
}
