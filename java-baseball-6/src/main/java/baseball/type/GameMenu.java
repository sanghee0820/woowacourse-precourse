package baseball.type;

import baseball.error.WrongMenuError;

public enum GameMenu {
    RESTART_GAME(1),
    END_GAME(2);

    private final Integer menuNumber;

    GameMenu(Integer i) {
        this.menuNumber = i;
    }

    public static GameMenu getMenu(int menuNumber) {
        for (GameMenu gameMenu : GameMenu.values()) {
            if (gameMenu.menuNumber == menuNumber) {
                return gameMenu;
            }
        }
        throw new WrongMenuError(": Caused In MenuEnum");
    }

}
