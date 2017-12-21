package Tictactoe.Controllers.RewardMaximization;

import java.util.HashMap;
import java.util.Map;

public class IncompleteGameExperience {
    private Map<String, String> decisions = new HashMap<>();

    public void addDecision(String state, String action) {
        if(decisions.containsKey(state))
            throw new RuntimeException("Already visited that state before");

        decisions.put(state, action);
    }

    Map<String, String> getDecisitions(){
        return decisions;
    }
}
