package Tictactoe.Controllers;

import Tictactoe.Tictactoe;
import java.util.Scanner;

import static Tictactoe.Tictactoe.*;

public class CmdPlayer implements TictactoeController{

    private String mySign, opponentSign;
    private Scanner scanner;

    public CmdPlayer(String mySign, String opponentSign, Scanner scanner){
        this.mySign = mySign;
        this.opponentSign = opponentSign;
        this.scanner = scanner;
    }

    @Override
    public int[] decideTurn(int[][] state) {
        System.out.println("### " + mySign + "'s turn ###");
        printState(state);
        System.out.println("Enter coordinates x,y:");
        String response = scanner.nextLine();
        String[] split = response.split(",");

        return new int[]{Integer.parseInt(split[0]),Integer.parseInt(split[1])};
    }

    private void printState(int[][] state){
        System.out.print("  ");
        for(int y = 0; y < state[1].length; y++)
            System.out.print(y + " ");

        System.out.print("\n");

        for(int x = 0; x < state.length; x++) {
            System.out.print(x + " ");

            for (int y = 0; y < state[x].length; y++) {
                if (state[x][y] == EMPTY)
                    System.out.print("-");
                else if (state[x][y] == ME)
                    System.out.print(mySign);
                else if (state[x][y] == OPPONENT)
                    System.out.print(opponentSign);
                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        System.out.println("Player " + mySign + " " + (result == Tictactoe.GameResult.Won ? "won" : "lost"));
    }
}
