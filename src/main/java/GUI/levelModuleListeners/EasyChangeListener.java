package GUI.levelModuleListeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;


public class EasyChangeListener extends MouseAdapter {



    @Override
    public void mouseClicked(MouseEvent e) {

        if(!levelList[0]){
            stateEasy = LevelGame.resize(easyOnIMG,70,70);
            easyStatePanel.getGraphics().drawImage(stateEasy, 0, 0, null);
            levelList[0]=true;


            // reszta
            stateMedium = LevelGame.resize(mediumIMG,70,70);
            mediumStatePanel.getGraphics().drawImage(stateMedium, 0, 0, null);
            levelList[1]=false;

            stateHard = LevelGame.resize(hardIMG,70,70);
            hardStatePanel.getGraphics().drawImage(stateHard, 0, 0, null);
            levelList[2]=false;

        }
       // stan.setText(pokazstany());
    }
}
