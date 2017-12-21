package Tictactoe.Main;

import Tictactoe.Controllers.ChristinesAI;
import Tictactoe.Controllers.CmdPlayer;
import Tictactoe.Controllers.RewardMaximization.CompleteGameExperiences;
import Tictactoe.Controllers.RewardMaximization.RewardMaximizationAI;
import Tictactoe.Tictactoe;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PlayerVsChristineAIMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tictactoe starting...");

        Tictactoe tictactoe = new Tictactoe(
                new ChristinesAI(new Random()),
                new CmdPlayer("X", "O", scanner)
        );

        while (tictactoe.doTurn() == Tictactoe.GameState.Running)
            System.out.println("New round");

        System.out.println("Game over");
    }
}

