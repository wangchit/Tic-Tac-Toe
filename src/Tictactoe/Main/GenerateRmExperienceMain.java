package Tictactoe.Main;

import Tictactoe.Controllers.RewardMaximization.CompleteGameExperiences;
import Tictactoe.Controllers.RewardMaximization.RmTrainingAI;
import Tictactoe.Tictactoe;

import java.io.IOException;
import java.util.Random;

public class GenerateRmExperienceMain {
    public static void main(String... args) throws IOException {
        Random random = new Random();
        CompleteGameExperiences exp = new CompleteGameExperiences();

        final int roundsToDo = 1000 * 1000;

        for(int games = 0; games < roundsToDo; games++) {
            Tictactoe tictactoe = new Tictactoe(
                    new RmTrainingAI(exp, random),
                    new RmTrainingAI(exp, random)
            );

            while (tictactoe.doTurn() == Tictactoe.GameState.Running);

            System.out.println("Done: " + games + " / " + roundsToDo + " -> " + Math.round(games / (double)roundsToDo * 100d) + "%");
        }

        System.out.println("Saving " + exp.getStatesCount() + " states...");
        exp.save("rmExperience_1m.bin");
    }
}
