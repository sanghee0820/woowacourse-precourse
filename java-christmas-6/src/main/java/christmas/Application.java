package christmas;

import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        EventController game = new EventController();
        game.setVisitor();
        game.getEventResult();
    }
}
