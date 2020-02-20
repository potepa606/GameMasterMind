package GUI.levelModuleListeners;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;

public class MediumChangeListener extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        if(!levelList[1]){


            mediumStatePanel.setIcon(new ImageIcon(LevelGame.resize(mediumOnIMG,70,70)));
            levelList[1] = true;

            // reszta
            easyStatePanel.setIcon(new ImageIcon(LevelGame.resize(easyIMG,70,70)));
            levelList[0] = false;
            hardStatePanel.setIcon(new ImageIcon(LevelGame.resize(hardIMG,70,70)));
            levelList[2] = false;


            pokazstany();
            // Za kazda zmiana levela resetowana jest hasło
            resetPlanets();
        }
    }
}
