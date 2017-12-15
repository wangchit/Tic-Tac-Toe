package Tictactoe.Controllers;

import Tictactoe.Tictactoe;

public interface TictactoeController {
    int[] decideTurn(int[][] state);
    void onGameOver(Tictactoe.GameResult result);
}
