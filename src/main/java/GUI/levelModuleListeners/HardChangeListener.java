package GUI.levelModuleListeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;

public class HardChangeListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!levelList[2]){
            stateHard = LevelGame.resize(hardOnIMG,70,70);
            hardStatePanel.getGraphics().drawImage(stateHard, 0, 0, null);
            levelList[2] = true;


            // reszta off
            stateEasy = LevelGame.resize(easyIMG,70,70);
            easyStatePanel.getGraphics().drawImage(stateEasy, 0, 0, null);
            levelList[0] = false;
            stateMedium = LevelGame.resize(mediumIMG,70,70);
            mediumStatePanel.getGraphics().drawImage(stateMedium, 0, 0, null);
            levelList[1] = false;
        }
        pokazstany();
        System.out.println( selectedLevelString );
    }
}
