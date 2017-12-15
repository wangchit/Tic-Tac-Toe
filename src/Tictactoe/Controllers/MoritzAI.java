package Tictactoe.Controllers;

import Tictactoe.Tictactoe;

public class MoritzAI implements TictactoeController {
    @Override
    public int[] decideTurn(int[][] state) {
        return new int[0];
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {

    }
}
