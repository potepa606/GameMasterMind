package GUI.panels.listeners;

import GUI.panels.LoginPanel;
import logic.Planet;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.panels.LoginPanel.*;

public class PlanetsListeners extends MouseAdapter {

    Planet planet = null;


    public PlanetsListeners(Planet p) {
        this.planet = p;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        final Planet p = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),planet.getSizes());
        p.setFontTitle(10);

        if(password.size() < 4){
            passworPanel.add(p);
            password.add(p);
            ballsPanel.remove(planet);
        }

        // dodawanie do listy w grze
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ballsPanel.add(planet);
                passworPanel.remove(p);
                password.remove(p);
                LoginPanel.reload();
            }
        });
        LoginPanel.reload();
    }
}
