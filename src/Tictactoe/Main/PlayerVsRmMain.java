package Tictactoe.Main;

import Tictactoe.Controllers.CmdPlayer;
import Tictactoe.Controllers.RewardMaximization.CompleteGameExperiences;
import Tictactoe.Controllers.RewardMaximization.RewardMaximizationAI;
import Tictactoe.Tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class PlayerVsRmMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        CompleteGameExperiences exp = new CompleteGameExperiences("rmExperience_1m.bin");
        System.out.println("Loaded experience with " + exp.getStatesCount() + " states");

        System.out.println("Tictactoe starting...");

        Tictactoe tictactoe = new Tictactoe(
                new RewardMaximizationAI(exp),
                new CmdPlayer("X", "O", scanner)
        );

        while (tictactoe.doTurn() == Tictactoe.GameState.Running)
            System.out.println("New round");

        System.out.println("Game over");
    }
}

