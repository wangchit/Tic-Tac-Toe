package Tictactoe.Controllers.RewardMaximization;

import Tictactoe.Controllers.TictactoeController;
import Tictactoe.Tictactoe;
import static Tictactoe.Controllers.RewardMaximization.RmTrainingAI.*;

public class RewardMaximizationAI implements TictactoeController {

    private CompleteGameExperiences experiences;

    public RewardMaximizationAI(CompleteGameExperiences experiences) {
        this.experiences = experiences;
    }

    @Override
    public int[] decideTurn(int[][] state) {
        String stateString = stateToString(state);
        return stringToAction(experiences.getBestAction(stateString));
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        System.out.println("Reward maximization AI " + result.name());
    }
}
