package Tictactoe.Main;

import Tictactoe.Controllers.ChristinesAI;
import Tictactoe.Controllers.CmdPlayer;
import Tictactoe.Tictactoe;

import java.util.Scanner;

public class PlayerVsPlayerMain {

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
