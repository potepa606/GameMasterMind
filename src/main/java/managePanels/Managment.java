package managePanels;


import GUI.panels.GamePanel;
import GUI.panels.LoginPanel;
import GUI.mainFrame.MainWindow;
import GUI.panels.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Managment{

    public static ArrayList<JPanel>  panels = new ArrayList<JPanel>();
    public static MainWindow mainWwindow;
    public static short maszynaPaneli = 0; //

    static {
        panels.add(new StartPanel()); // Panel Startowy
        panels.add(new LoginPanel()); // Panel Konfiguracyjny gry
        panels.add(new GamePanel()); // Panel gry glownej
    }

    public static void setPanel(int chosenPanel){
        for(int i=0; i<panels.size();i++){
            if(i == chosenPanel)
                continue;
            panels.get(i).setVisible(false);
        }
        mainWwindow.add(Managment.panels.get(chosenPanel));
        panels.get(chosenPanel).setVisible(true);
    }



    public static void startAPI () {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWwindow = new MainWindow();
                mainWwindow.setFavIcon();
                mainWwindow.setVisible(true);
            }
        });
    }


}
