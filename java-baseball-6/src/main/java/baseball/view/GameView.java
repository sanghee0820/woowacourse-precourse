package baseball.view;

import baseball.type.Result;

public class GameView {
    private final String startGame = "숫자 야구 게임을 시작합니다.";
    private final String getInput = "숫자를 입력해주세요 : ";
    private final String endGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String restartGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartGame() {
        System.out.println(startGame);
    }

    public void printGetInput() {
        System.out.print(getInput);
    }

    public void printEndGame() {
        System.out.println(endGame);
    }

    public void printRestartGame() {
        System.out.println(restartGame);
    }

    public void printResult(Result result) {
        System.out.println(result);
    }
}
