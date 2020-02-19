package GUI.panels.listeners;

import GUI.levelModuleListeners.LevelGame;
import GUI.panels.GamePanel;
import logic.Planet;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;

import static GUI.levelModuleListeners.LevelGame.*;
import static GUI.panels.GamePanel.*;
import static GUI.panels.LoginPanel.*;
import static logic.LoadComponents.earth100;
import static logic.LoadComponents.jupiter100;

public class PlanetListenerGame_GamePanel extends MouseAdapter {

    private Planet planet;
    public PlanetListenerGame_GamePanel(Planet planet) {
        this.planet = planet;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        //super.mousePressed(e);
        if(testPanel.getComponentCount() < setPlanetDepdecyLevel() ) {
            if(selectedLevelString.equals("easy")){
                easyLevel();
            }else if(selectedLevelString.equals("medium")){

            }else if(selectedLevelString.equals("hard")){
                hardLevel();
            }
            GamePanel.reload();
        }
        myGameScrollablePanel.getVerticalScrollBar().setValue( myGameScrollablePanel.getVerticalScrollBar().getMaximum());
    }

    private   void easyLevel(){
        final Planet NowaPlanetaDoHasla = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),100);
        NowaPlanetaDoHasla.setStanAktualny(true);
        // Usuwanie z glownej
        zbiórWszysktichJPanel.remove(planet); // JPanel
        plentyUsunietezZGlownego.add(planet); // przechowalnia
        //dodawanie do hasla
        planetyDoZamrozenia.add(NowaPlanetaDoHasla); // Lista
        testPanel.add(NowaPlanetaDoHasla); // JPanel

        NowaPlanetaDoHasla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(planetyDoZamrozenia.contains(NowaPlanetaDoHasla) && NowaPlanetaDoHasla.isStanAktualny()){
                    planetyDoZamrozenia.remove(NowaPlanetaDoHasla);
                    testPanel.remove(NowaPlanetaDoHasla);

                    zbiórWszysktichJPanel.add(planet);
                    plentyUsunietezZGlownego.remove(planet);
                    GamePanel.reload();
                }

            }
        });
    }
    private void hardLevel(){
        final Planet NowaPlanetaDoHasla = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),75);
        NowaPlanetaDoHasla.setStanAktualny(true);
        // Usuwanie z glownej
        zbiórWszysktichJPanel.remove(planet); // JPanel
        plentyUsunietezZGlownego.add(planet); // przechowalnia
        //dodawanie do hasla
        planetyDoZamrozenia.add(NowaPlanetaDoHasla); // Lista
        testPanel.add(NowaPlanetaDoHasla); // JPanel
        NowaPlanetaDoHasla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(planetyDoZamrozenia.contains(NowaPlanetaDoHasla) && NowaPlanetaDoHasla.isStanAktualny()){
                    planetyDoZamrozenia.remove(NowaPlanetaDoHasla);
                    testPanel.remove(NowaPlanetaDoHasla);

                    zbiórWszysktichJPanel.add(planet);
                    plentyUsunietezZGlownego.remove(planet);
                    GamePanel.reload();
                }

            }
        });
    }
}
