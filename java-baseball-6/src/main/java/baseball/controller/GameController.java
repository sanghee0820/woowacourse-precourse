package baseball.controller;

import baseball.domain.Computer;
import baseball.service.ViewValidator;
import baseball.type.Result;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {
    private static final Integer END_GAME = 2;
    private static final Integer RESTART_GAME = 1;

    private Integer menu = 1;
    private final GameView gameView;
    private Result result;

    public GameController() {
        gameView = new GameView();
    }

    public void runGame() {
        while (menu.equals(RESTART_GAME)) {
            Computer computer = new Computer();
            do {
                gameView.printStartGame();
                gameView.printGetInput();
                String input = Console.readLine();
                List<Integer> validatedInput = ViewValidator.validateInput(input);
                result = computer.compareValue(validatedInput);
                gameView.printResult(result);
            } while (!result.equals(Result.B0S3));
            gameView.printEndGame();
            gameView.printRestartGame();
            String menuInput = Console.readLine();
            menu = ViewValidator.validateMenu(menuInput);
        }
    }
}
