package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.MyButton;
import logic.JPanelWithPlanets;
import logic.JScrollablePanel;
import logic.Planet;
import logic.PlanetListenerGame;
import net.miginfocom.swing.MigLayout; // If you're just using this one class

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GUI.levelModuleListeners.LevelGame.stateMedium;
import static GUI.panels.StartPanel.backgound;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static logic.LoadComponents.*;


public class GamePanel extends JPanel {

    public  static JScrollablePanel myGameScrollablePanel = new JScrollablePanel();
    public  static JPanelWithPlanets zbiórWszysktichJPanel = new JPanelWithPlanets();

    public static ArrayList<Planet> plentyUsunietezZGlownego = new ArrayList<Planet>();

    public  static  JPanel testPanel , lampInfoPanel;
    public static ArrayList<Planet> planetyDoZamrozenia = new ArrayList<Planet>();






    public GamePanel( ) {
        setLayout(null);
        add(myGameScrollablePanel);
        add(zbiórWszysktichJPanel);
        myGameScrollablePanel.addPanelPass(testaddPanel(),"");
        myGameScrollablePanel.addPanelPass(addPanelInfo(),"wrap");






        JButton testBut = new MyButton("zatwierdz",30,130,500);
        testBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(testPanel.getComponentCount() >= 4){
                    for (Planet p:plentyUsunietezZGlownego)
                        zbiórWszysktichJPanel.add(p);
                    plentyUsunietezZGlownego.clear();


                    sampleLampCheck();
                    myGameScrollablePanel.addPanelPass(testaddPanel(),"");
                    myGameScrollablePanel.addPanelPass(addPanelInfo(),"wrap");
                    isCorectPasswrod();



                }
                reload();
            }
        });
        add(testBut);
    }

    public JPanel testaddPanel(){
        testPanel  = new JPanel(){
          protected void paintComponent(Graphics g)
          {   //Set full transparency background
              super.paintComponent(g);
              Dimension arcs = new Dimension(20,20);
              int width = getWidth();
              int height = getHeight();
              Graphics2D graphics = (Graphics2D) g;
              graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
              //Draws the rounded opaque panel with borders.
              graphics.setColor(getBackground());
              graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
              graphics.setColor(getForeground());
              graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
          }
        };
        testPanel.setLayout(new MigLayout("fill, alignx center, insets 0"));

        testPanel.setForeground(Color.BLACK);
        testPanel.setBounds(0, 0, 70, 70);
        testPanel.setOpaque(false);
        testPanel.setBackground( new Color(13, 13, 13, 232) );
        testPanel.setBorder(BorderFactory.createEmptyBorder());
        return testPanel;
    }
    public JPanel addPanelInfo(){
        lampInfoPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Dimension arcs = new Dimension(20,20);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        lampInfoPanel.setLayout(new MigLayout("fill, alignx center, insets 1"));
        lampInfoPanel.setForeground(Color.BLACK);
        lampInfoPanel.setBounds(0, 0, 70, 70);
        lampInfoPanel.setOpaque(false);
        lampInfoPanel.setBackground( new Color(13, 13, 13, 232) );
        lampInfoPanel.setBorder(BorderFactory.createEmptyBorder());
        return lampInfoPanel;
    }
    public static boolean isCorectPasswrod(){
        int lenghOfPass = LoginPanel.password.size();
        if(lenghOfPass == planetyDoZamrozenia.size()){
            for(int i = 0; i<lenghOfPass; i++){
                if(!planetyDoZamrozenia.get(i).equals(LoginPanel.password.get(i))){
                    System.out.println("Roznia sie");
                    planetyDoZamrozenia.clear();
                    return false;
                }
            }
            System.out.println("Sa takie same !");
            planetyDoZamrozenia.clear();
            return true;
        }
        else {
            System.out.println("Hasla maja rozna dlugosc");
            planetyDoZamrozenia.clear();
            return false;
        }
    }
    public static void setImageLampGroup(int correctPlanet, int contain){

        LampInfo[] lampGroup = new LampInfo[4];

        for(int i=0; i<correctPlanet; i++){
            lampGroup[i] = new LampInfo(green_Lamp,35,25);
        }
        for(int i = correctPlanet ; i<contain;i++){
            lampGroup[i] = new LampInfo(red_Lamp,35,25);
        }
        for(int i = contain ; i<lampGroup.length;i++){
            lampGroup[i] = new LampInfo(empty_Lamp,35,25);
        }

        for (LampInfo lampInfo: lampGroup)
            lampInfoPanel.add(lampInfo, "wrap");


    }


    public static void sampleLampCheck(){
        ArrayList<Planet> pass = LoginPanel.password;
        ArrayList<Planet> samplePass = planetyDoZamrozenia;
        int correctPlanet = 0 , contain = 0;

        System.out.println("rozmiar password" + pass.size());
        System.out.println("rozmiar samplePass" + samplePass.size());



        for (int i = 0 ; i<samplePass.size();i++) {
            if(pass.get(i).getNamePlanet().equals(samplePass.get(i).getNamePlanet())) {
                correctPlanet++;
                contain++;
            }else{
                for (Planet p: pass) {
                    if(samplePass.get(i).getNamePlanet().equals(p.getNamePlanet()))
                        contain++;
                }
            }
        }
        System.out.println("Poprawnych: " + correctPlanet);
        System.out.println("Znajduje sie: " + contain);


        setImageLampGroup(correctPlanet,contain);

    }




    public static void reload(){
        myGameScrollablePanel.revalidate();
        myGameScrollablePanel.repaint();
        zbiórWszysktichJPanel.revalidate();
        zbiórWszysktichJPanel.repaint();
    }

    public static void loadStartPlanets(){
            for (final Planet planet: LoginPanel.allPlanetsArrList) {
                Planet newPlanet = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),50);
                newPlanet.addMouseListener(new PlanetListenerGame(newPlanet));
                zbiórWszysktichJPanel.add(newPlanet);
            }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH.getSize() ,WINDOW_HEIGHT.getSize());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgound, 0, 0, this); // see javadoc for more info on the parameters
        //g.drawImage(headerImage, 60, 0, this); // see javadoc for more info on the parameters
    }

}

class LampInfo extends JLabel{
    private  BufferedImage lampImage;
    private int sizeX,sizeY;
    public LampInfo(BufferedImage lampImage, int sizeX, int sizeY) {
        this. lampImage = lampImage;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setIcon(new javax.swing.ImageIcon(LevelGame.resize(lampImage, sizeX, sizeY)));
    }

    public void setLampImage(BufferedImage lampImage) {
        this.lampImage = lampImage;
        setIcon(new javax.swing.ImageIcon(LevelGame.resize( this.lampImage, sizeX, sizeY)));
    }
}