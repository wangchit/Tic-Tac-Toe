package Tictactoe;

import Tictactoe.Controllers.TictactoeController;

public class Tictactoe {

    public enum GameState{
        Running, Finished
    }

    public enum GameResult{
        Won, Lost
    }

    private int state[][] = new int[3][3];
    private TictactoeController[] controllers;
    private int turn = 0;

    public static final int EMPTY = -1;
    public static final int ME = 1;
    public static final int OPPONENT = 2;

    public Tictactoe(TictactoeController playerOne, TictactoeController playerTwo){
        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++)
                state[x][y] = EMPTY;

        controllers = new TictactoeController[]{playerOne, playerTwo};
    }

    public GameState doTurn(){
        int currentPlayerId = turn % 2;
        TictactoeController currentPlayer = controllers[currentPlayerId];

        int stateCopy[][] = new int[3][3];
        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++) {
                if(state[x][y] == currentPlayerId)
                    stateCopy[x][y] = ME;
                else if(state[x][y] != EMPTY)
                    stateCopy[x][y] = OPPONENT;
                else
                    stateCopy[x][y] = EMPTY;
            }

        int[] newPosition = currentPlayer.decideTurn(stateCopy);
        int x = newPosition[0];
        int y = newPosition[1];

        int selectedField = state[x][y];

        if(selectedField != EMPTY)
            throw new IllegalMoveException("Field " + x + " " + y + " is already occupied");

        state[x][y] = currentPlayerId;

        boolean currentPlayerWins =
                ((state[x][y] == state[(x + 1) % 3][y]) && (state[x][y] == state[(x + 2) % 3][y])) ||
                ((state[x][y] == state[x][(y + 1) % 3]) && (state[x][y] == state[x][(y + 2) % 3])) ||
                ((state[x][y] == state[(x + 1) % 3][(y + 1) % 3]) && (state[x][y] == state[(x + 2) % 3][(y + 2) % 3]));

        if (x == 1 & y == 1)
            currentPlayerWins = currentPlayerWins || ((state[x][y] == state[(x + 1) % 3][(y + 2) % 3]) && (state[x][y] == state[(x + 2) % 3][(y + 1) % 3]));

        if(currentPlayerWins) {
            for (TictactoeController c : controllers)
                if (c == currentPlayer)
                    c.onGameOver(GameResult.Won);
                else
                    c.onGameOver(GameResult.Lost);

            return GameState.Finished;
        }

        turn++;

        return GameState.Running;
    }

}
