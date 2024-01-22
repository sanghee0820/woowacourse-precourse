package baseball.controller;

import baseball.model.Computer;
import baseball.type.GameMenu;
import baseball.type.Result;
import baseball.util.ViewValidator;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameController {
    private GameMenu menu = GameMenu.RESTART_GAME;
    private final GameView gameView;

    public GameController() {
        gameView = new GameView();
    }

    public void runGame() {
        while (menu.equals(GameMenu.RESTART_GAME)) {
            stepGame();
        }
    }

    private void stepGame() {
        Computer computer = new Computer();
        Result result;
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
        this.menu = ViewValidator.validateMenu(Console.readLine());
    }
}
