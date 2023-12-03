package controller;

import domain.panel.Board;

public class SystemController {
    private SystemController() {
    }

    public static void start() {
        Board board = Board.create();
        board.show();
    }
}
