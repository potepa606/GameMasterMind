package logic;

import GUI.levelModuleListeners.LevelGame;
import GUI.panels.GamePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;

import static GUI.levelModuleListeners.LevelGame.*;
import static GUI.panels.GamePanel.*;
import static GUI.panels.LoginPanel.*;

public class PlanetListenerGame extends MouseAdapter {

    private Planet planet;
    public PlanetListenerGame(Planet planet) {
        this.planet = planet;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(testPanel.getComponentCount()<4 ) {

            final Planet NowaPlanetaDoHasla = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),100);
            // Usuwanie z glownej
            zbiórWszysktichJPanel.remove(planet); // JPanel
            plentyUsunietezZGlownego.add(planet); // przechowalnia
            //dodawanie do hasla
            planetyDoZamrozenia.add(NowaPlanetaDoHasla); // Lista
            testPanel.add(NowaPlanetaDoHasla); // JPanel
            NowaPlanetaDoHasla.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(planetyDoZamrozenia.contains(NowaPlanetaDoHasla)){
                        planetyDoZamrozenia.remove(NowaPlanetaDoHasla);
                        testPanel.remove(NowaPlanetaDoHasla);

                        zbiórWszysktichJPanel.add(planet);
                        plentyUsunietezZGlownego.remove(planet);
                        GamePanel.reload();
                    }

                }
            });


            GamePanel.reload();
        }
    }
}
