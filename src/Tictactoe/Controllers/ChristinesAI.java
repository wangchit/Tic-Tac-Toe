package Tictactoe.Controllers;

import Tictactoe.Tictactoe;
import static Tictactoe.Tictactoe.*;

public class ChristinesAI implements TictactoeController {

    @Override
    public int[] decideTurn(int[][] state) {
        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++) {

                if (state[x][y] == state[(x + 1) % 3][y])
                    return new int[]{(x + 2) % 3, y};
                else if (state[x][y] == state[(x + 2) % 3][y])
                    return new int[]{(x + 1) % 3, y};
                else if (state[x][y] == state[x][(y + 1) % 3])
                    return new int[]{x, (y + 2) % 3};
                else if (state[x][y] == state[x][(y + 2) % 3])
                    return new int[]{x, (y + 1) % 3};

                else if (x == y){
                    if(state[x][y] == state[(x + 1) % 3][(y + 1) % 3])
                        return new int[]{(x + 2) % 3, (y + 2) % 3};
                    else if(state[x][y] == state[(x + 2) % 3][(y + 2) % 3])
                        return new int[]{(x + 1) % 3, (y + 1) % 3};
                }

                 else if (x == (2 - y)){
                    if(state[x][y] == state[(x + 1) % 3][(y + 2) % 3])
                        return new int[]{(x + 2) % 3, (y + 1) % 3};
                    else if(state[x][y] == state[(x + 2) % 3][(y + 1) % 3])
                        return new int[]{(x + 1) % 3, (y + 2) % 3};
                }

                else if (state[1][1] != EMPTY)
                    return new int[]{1,1};

                else if (state[x][y] != EMPTY)
                    return new int[]{x,y};
            }
            return null;
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        System.out.println("Christines AI " + (result == Tictactoe.GameResult.Won ? "won" : result == Tictactoe.GameResult.Draw ? "Draw":"lost"));
    }
}
