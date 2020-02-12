package GUI.levelModuleListeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;

public class MediumChangeListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(!levelList[1]){
            stateMedium = LevelGame.resize(mediumOnIMG,70,70);
            mediumStatePanel.getGraphics().drawImage(stateMedium, 0, 0, null);
            levelList[1] = true;

            // reszta
            stateEasy = LevelGame.resize(easyIMG,70,70);
            easyStatePanel.getGraphics().drawImage(stateEasy, 0, 0, null);
            levelList[0] = false;
            stateHard = LevelGame.resize(hardIMG,70,70);
            hardStatePanel.getGraphics().drawImage(stateHard, 0, 0, null);
            levelList[2] = false;
        }
       // stan.setText(pokazstany());

    }
}
