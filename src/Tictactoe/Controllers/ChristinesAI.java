package Tictactoe.Controllers;

import Tictactoe.Tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Tictactoe.Tictactoe.*;

public class ChristinesAI implements TictactoeController {

    private Random random;

    public ChristinesAI(Random random){
        this.random = random;
    }

    @Override
    public int[] decideTurn(int[][] state) {
        if (state[1][1] == EMPTY)
            return new int[]{1,1};

        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++) {
                if (state[x][y] != EMPTY) {

                    if (state[x][y] == state[(x + 1) % 3][y]) {
                        if (state[(x + 2) % 3][y] == EMPTY)
                            return new int[]{(x + 2) % 3, y};
                    }

                    if (state[x][y] == state[(x + 2) % 3][y]) {
                        if (state[(x + 1) % 3][y] == EMPTY)
                        return new int[]{(x + 1) % 3, y};
                    }

                    if (state[x][y] == state[x][(y + 1) % 3]) {
                        if (state[x][(y + 2) % 3] == EMPTY)
                        return new int[]{x, (y + 2) % 3};
                    }

                    if (state[x][y] == state[x][(y + 2) % 3]) {
                        if (state[x][(y + 1) % 3] == EMPTY)
                        return new int[]{x, (y + 1) % 3};
                    }

                    if (x == y) {
                        if (state[x][y] == state[(x + 1) % 3][(y + 1) % 3])
                            if (state[(x + 2) % 3][(y + 2) % 3] == EMPTY)
                                return new int[]{(x + 2) % 3, (y + 2) % 3};

                        if (state[x][y] == state[(x + 2) % 3][(y + 2) % 3])
                            if (state[(x + 1) % 3][(y + 1) % 3] == EMPTY)
                                return new int[]{(x + 1) % 3, (y + 1) % 3};
                    }

                    if (x == (2 - y)) {
                        if (state[x][y] == state[(x + 1) % 3][(y + 2) % 3])
                            if (state[(x + 2) % 3][(y + 1) % 3] == EMPTY)
                                return new int[]{(x + 2) % 3, (y + 1) % 3};

                        if (state[x][y] == state[(x + 2) % 3][(y + 1) % 3])
                            if (state[(x + 1) % 3][(y + 2) % 3] == EMPTY)
                                return new int[]{(x + 1) % 3, (y + 2) % 3};
                    }
                }
            }

        List<int[]> possibilities = new ArrayList<>();
        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++){
                if (state[x][y]==EMPTY)
                    possibilities.add(new int[]{x,y});
            }

        return possibilities.get((int)(possibilities.size()*random.nextDouble()));
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        System.out.println("Christines AI " + (result == Tictactoe.GameResult.Won ? "won" : result == Tictactoe.GameResult.Draw ? "Draw":"lost"));
    }
}
