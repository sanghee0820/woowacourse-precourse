package racingcar.controller;

import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;

    private final OutputView outputView;
    private int gameCount;
    public GameController(){
        this.gameService = new GameService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void getInput(){
        String names = inputView.getName();
        String count = inputView.getCount();
        gameService.addParticipant(Parser.parseName(names));
        this.gameCount = Parser.parsCount(count);
    }

    public void getOutput(){
        outputView.printStepStart();
        runGame();
        outputView.printResult(gameService.getWinner());
    }

    private void runGame(){
        for(int i = 0; i < gameCount; i++){
            gameService.takeStep();
            outputView.printStepResult(gameService.getParticipants());
        }
    }
}
