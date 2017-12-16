package Tictactoe.Controllers.PayoffMaximization;

import Tictactoe.Controllers.TictactoeController;
import Tictactoe.Tictactoe;
import static Tictactoe.Controllers.PayoffMaximization.TrainingAI.*;

public class TrainedAI implements TictactoeController {

    private CompleteGameExperiences experiences;

    public TrainedAI(CompleteGameExperiences experiences) {
        this.experiences = experiences;
    }

    @Override
    public int[] decideTurn(int[][] state) {
        String stateString = stateToString(state);
        return stringToAction(experiences.getBestAction(stateString));
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        System.out.println("Trained AI " + result.name());
    }
}
