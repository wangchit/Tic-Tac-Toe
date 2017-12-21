package Tictactoe.Main;

import Tictactoe.Controllers.ChristinesAI;
import Tictactoe.Controllers.RewardMaximization.CompleteGameExperiences;
import Tictactoe.Controllers.RewardMaximization.RewardMaximizationAI;
import Tictactoe.Tictactoe;

import java.io.IOException;
import java.util.Random;

public class ChristineVsRmMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Random r = new Random();
        CompleteGameExperiences exp = new CompleteGameExperiences("rmExperience_1m.bin");
        System.out.println("Loaded experience with " + exp.getStatesCount() + " states");

        System.out.println("Tictactoe starting...");

        int christinewin = 0, moritzwin = 0;

        for (int i = 0; i<1000; i++){
            RewardMaximizationAI moritzAI = new RewardMaximizationAI(exp);
            ChristinesAI christinesAI = new ChristinesAI(r);

            Tictactoe tictactoe = i % 2 == 0 ?
                    new Tictactoe(moritzAI, christinesAI):
                    new Tictactoe(christinesAI, moritzAI);

            while (tictactoe.doTurn() == Tictactoe.GameState.Running);

            if(tictactoe.getWinner() == christinesAI)
                christinewin++;

            if(tictactoe.getWinner() == moritzAI)
                moritzwin++;
        }

        System.out.println("Christine AI won " + christinewin);
        System.out.println("Moritz AI won " + moritzwin);
    }
}

