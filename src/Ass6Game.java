
import Objects.AnimationRunner;
import Objects.GameFlow;
import Objects.LevelInfo.DirectHit;
import Objects.LevelInfo.FinalFour;
import Objects.LevelInfo.Green3;
import Objects.LevelInfo.WideEasy;
import Objects.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.LinkedList;
import java.util.List;


/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Ass6Game {
    /**
     * the main function how initialize the game
     * and run it.
     *
     * @param args String[].
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformationList = new LinkedList<>();
        levelInformationList.add(new DirectHit());
        levelInformationList.add(new WideEasy());
        levelInformationList.add(new Green3());
        levelInformationList.add(new FinalFour());
        List<LevelInformation> levelInformationList2 = new LinkedList<>();
        for (String arg : args) {
            if (arg.equals("1")) {
                levelInformationList2.add(levelInformationList.get(0));
            }
            if (arg.equals("2")) {
                levelInformationList2.add(levelInformationList.get(1));
            }
            if (arg.equals("3")) {
                levelInformationList2.add(levelInformationList.get(2));
            }
            if (arg.equals("4")) {
                levelInformationList2.add(levelInformationList.get(3));
            }
        }
        if (levelInformationList2.size() == 0) {
            levelInformationList2.addAll(levelInformationList);
        }
        AnimationRunner ar = new AnimationRunner();
        GUI gui = new GUI("Game", 800, 600);
        KeyboardSensor ks = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(ar, ks, gui);
        gameFlow.runLevels(levelInformationList2);
    }
}