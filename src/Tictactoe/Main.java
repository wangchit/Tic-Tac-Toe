package Tictactoe;

import Tictactoe.Controllers.ChristinesAI;
import Tictactoe.Controllers.CmdPlayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tictactoe starting...");

        Scanner scanner = new Scanner(System.in);

	    Tictactoe tictactoe = new Tictactoe(
	            new ChristinesAI(),
                new CmdPlayer("X", "O", scanner)
        );

	    while (tictactoe.doTurn() == Tictactoe.GameState.Running)
            System.out.println("New round");

	    System.out.println("Game over");
    }
}
