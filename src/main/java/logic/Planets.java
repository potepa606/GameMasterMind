package logic;

import javax.imageio.ImageIO;

import static logic.LoadComponents.*;

public enum Planets {

    EARTH(new Planet("Ziemia", earth50,50)),
   JUPITER(new Planet("Jowisz", jupiter50,50)),
    MARS(new Planet("Mars", mars50,50)),
    EUROPA_MOON(new Planet("Europa Moon", europa50,50)),
    KALISTO_MOON(new Planet("Kalisto Moon", kalisto50,50)),
    IO_MOON(new Planet("IO Moon", io50,50)),
    SATURN(new Planet("Saturn", saturn50,50)),
    BETELGEZA(new Planet("Betelgeza", betelgeza50,50)),
    SYRIUSZ(new Planet("Syriusz", syriusz50,50)),
    URAN(new Planet("Uran", uran50,50));

    Planet planeta;


    Planets(Planet p) {
        this.planeta = p;
    }

    public Planet getPlanet() {
        return planeta;
    }
}






