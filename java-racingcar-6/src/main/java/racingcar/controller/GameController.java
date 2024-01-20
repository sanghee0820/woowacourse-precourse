package racingcar.controller;

import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;

public class GameController {
    private GameService gameService;
    private InputView inputView;
    private int gameCount;
    public GameController(){
        this.gameService = new GameService();
        this.inputView = new InputView();
    }

    public void getInput(){
        String names = inputView.getName();
        String count = inputView.getCount();
        gameService.addParticipant(Parser.parseName(names));
        this.gameCount = Parser.parsCount(count);
    }
}
