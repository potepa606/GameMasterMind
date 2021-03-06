package logic;

import GUI.levelModuleListeners.LevelGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;


public class Planet extends JLabel {


    private BufferedImage imagePlanet ;
    private String namePlanet;
    private int size;
    private boolean stanAktualny;


    public Planet(final String namePlanet, BufferedImage imagePlanet){
        setText("<html><b> <font color='white'> " + namePlanet + " </font></b></html>");
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.BOTTOM);
        setOpaque(false);
        setBackground( new Color(255, 255, 255, 0) );
        setIcon(new javax.swing.ImageIcon(imagePlanet));
        this.imagePlanet = imagePlanet;
        this.namePlanet = namePlanet;

    }

    public Planet(final String namePlanet, BufferedImage imagePlanet, int size) {
        this(namePlanet,imagePlanet);
        this.size = size;
        setIcon(new javax.swing.ImageIcon(LevelGame.resize(imagePlanet, size, size)));
    }


    public boolean isStanAktualny() {
        return stanAktualny;
    }

    public void setStanAktualny(boolean stanAktualny) {
        this.stanAktualny = stanAktualny;
    }

    public BufferedImage getImagePlanet() {
        return imagePlanet;
    }

    public void setImagePlanet(BufferedImage imagePlanet) {
        this.imagePlanet = imagePlanet;
    }


    public String getNamePlanet() {
        return namePlanet;
    }

    public void setNamePlanet(String namePlanet) {
        this.namePlanet = namePlanet;
    }
    public int getSizes() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        setIcon(new javax.swing.ImageIcon(LevelGame.resize(this.imagePlanet, this.size, this.size)));
    }


    public void setFontTitle(int size){
        setFont(new Font(Font.DIALOG, Font.PLAIN, size));
        setText("<html><b> <font color='white'> " + namePlanet + " </font></b></html>");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }



    @Override
    public String toString() {
        return  namePlanet ;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return this.getNamePlanet().equals(planet.getNamePlanet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePlanet);
    }
}
