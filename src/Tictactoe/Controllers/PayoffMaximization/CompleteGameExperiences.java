package Tictactoe.Controllers.PayoffMaximization;

import java.io.*;
import java.util.*;

class RewardStatistics{
    public int tried = 0, won = 0;
    public double getWinningRate(){
        return (double) won / (double) tried;
    }
}

public class CompleteGameExperiences {

    private Map<String, Map<String, RewardStatistics>> totalExperience;

    public CompleteGameExperiences(){
        totalExperience = new HashMap<>();
    }

    public CompleteGameExperiences(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        totalExperience = (Map<String, Map<String, RewardStatistics>>) in.readObject();
        in.close();
        fileIn.close();
    }

    public void save(String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(totalExperience);
        out.close();
        fileOut.close();
    }

    public void addCompletedExperience(IncompleteGameExperience incompleteGameExperience, boolean won) {
        Map<String, String> decisions = incompleteGameExperience.getDecisitions();

        for(Map.Entry<String, String> pair : decisions.entrySet()){
            String state = pair.getKey();
            String action = pair.getValue();

            if(!totalExperience.containsKey(state))
                totalExperience.put(state, new HashMap<>());

            Map<String, RewardStatistics> actions = totalExperience.get(state);

            if(!actions.containsKey(action))
                actions.put(action, new RewardStatistics());

            RewardStatistics stats = actions.get(action);

            stats.tried++;
            if(won)
                stats.won++;
        }
    }

    public String getBestAction(String state){
        if(!totalExperience.containsKey(state))
            return null;

        String bestAction = null;
        double bestWinningRate = 0;
        for(Map.Entry<String, RewardStatistics> entry : totalExperience.get(state).entrySet()) {
            if(entry.getValue().getWinningRate() > bestWinningRate){
                bestAction = entry.getKey();
                bestWinningRate = entry.getValue().getWinningRate();
            }
        }

        return bestAction;
    }
}
