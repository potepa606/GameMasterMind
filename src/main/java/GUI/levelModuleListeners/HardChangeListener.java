package GUI.levelModuleListeners;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;

public class HardChangeListener extends MouseAdapter {


    public HardChangeListener() {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!levelList[2]){
            hardStatePanel.setIcon(new ImageIcon(LevelGame.resize(hardOnIMG,70,70)));
            levelList[2] = true;

            // reszta off
            easyStatePanel.setIcon(new ImageIcon(LevelGame.resize(easyIMG,70,70)));
            levelList[0] = false;
            mediumStatePanel.setIcon(new ImageIcon(LevelGame.resize(mediumIMG,70,70)));
            levelList[1] = false;

            pokazstany();
            // Za kazda zmiana levela resetowana jest hasło
            resetPlanets();
        }
    }
}
