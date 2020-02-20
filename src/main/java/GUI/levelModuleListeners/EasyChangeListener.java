package GUI.levelModuleListeners;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;
import static GUI.levelModuleListeners.LevelGame.*;


public class EasyChangeListener extends MouseAdapter {



    @Override
    public void mousePressed(MouseEvent e) {

        if(!levelList[0]){

            easyStatePanel.setIcon(new ImageIcon(LevelGame.resize(easyOnIMG,70,70)));
            levelList[0]=true;

            // reszta
            mediumStatePanel.setIcon(new ImageIcon(LevelGame.resize(mediumIMG,70,70)));
            levelList[1]=false;
            hardStatePanel.setIcon(new ImageIcon(LevelGame.resize(hardIMG,70,70)));
            levelList[2]=false;

            pokazstany();
            // Za kazda zmiana levela resetowana jest hasło
            resetPlanets();
        }
    }
}
