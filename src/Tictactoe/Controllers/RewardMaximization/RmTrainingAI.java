package Tictactoe.Controllers.RewardMaximization;

import Tictactoe.Controllers.TictactoeController;
import Tictactoe.Tictactoe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static Tictactoe.Tictactoe.EMPTY;

public class RmTrainingAI implements TictactoeController {

    private IncompleteGameExperience incompleteGameExperience = new IncompleteGameExperience();
    private CompleteGameExperiences experiences;
    private Random random;

    public RmTrainingAI(CompleteGameExperiences experiences, Random random){
        this.experiences = experiences;
        this.random = random;
    }

    static String stateToString(int[][] state){
        StringBuilder output = new StringBuilder();
        for(int[] row : state) {
            for (int i : row)
                output.append(i + "|");
            output.append("#");
        }

        return output.toString();
    }

    static String actionToString(int[] action){
        StringBuilder output = new StringBuilder();
        for(int i : action)
            output.append(i + "|");

        return output.toString();
    }

    static int[] stringToAction(String actionString){
        int[] output = Arrays.stream(actionString.split("\\|")).mapToInt(e -> Integer.parseInt(e)).toArray();
        if(output.length != 2)
            throw new RuntimeException("Array length should be 2, is " + output.length);
        return output;
    }

    @Override
    public int[] decideTurn(int[][] state) {
        List<int[]> possibleActions = new LinkedList<>();
        for(int x = 0; x < state.length; x++)
            for(int y = 0; y < state[x].length; y++)
                if(state[x][y] == EMPTY)
                    possibleActions.add(new int[]{x, y});

        //Todo: Are all elements possible like that?
        int[] decision = possibleActions.get((int)(possibleActions.size() * random.nextDouble()));

        String actionString = actionToString(decision);
        String stateString = stateToString(state);

        incompleteGameExperience.addDecision(stateString, actionString);

        return decision;
    }

    @Override
    public void onGameOver(Tictactoe.GameResult result) {
        experiences.addCompletedExperience(incompleteGameExperience, result != Tictactoe.GameResult.Lost);
    }
}
