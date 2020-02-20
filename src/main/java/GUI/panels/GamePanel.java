package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.MyButton;
import logic.Planet;
import GUI.panels.listeners.PlanetListenerGame_GamePanel;
import net.miginfocom.swing.MigLayout; // If you're just using this one class
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GUI.levelModuleListeners.LevelGame.*;
import static GUI.panels.LoginPanel.*;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static logic.LoadComponents.*;
import static managePanels.Managment.setPanel;


public class GamePanel extends JPanel {

    public  static JScrollablePanel myGameScrollablePanel = new JScrollablePanel();
    public  static JPanelWithPlanets zbiorWszysktichJPanel = new JPanelWithPlanets();
    public static ArrayList<Planet> plentyUsunietezZGlownego = new ArrayList<Planet>();
    public  static  JPanel testPanel , lampInfoPanel;
    public static JLabel probaLabel, iconLevel, playerName;
    public static ArrayList<Planet> planetyDoZamrozenia = new ArrayList<Planet>();
    private JButton sprawdzButton, przerwijButton;

    private  LoseGamePanel losepanel = new LoseGamePanel();
    private  WinGamePanel winpanel ;

    public static int  proba = 0 ;





    public GamePanel( ) {
        setLayout(null);
        add(myGameScrollablePanel);
        add(zbiorWszysktichJPanel);



        //myGameScrollablePanel.addPanelPass(testaddPanel(),"");
        //myGameScrollablePanel.addPanelPass(addPanelInfo(),"wrap");

        sprawdzButton = new MyButton("Sprawdź",34,163,513);
        sprawdzButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(testPanel.getComponentCount() >= setPlanetDepdecyLevel()){
                    for (Planet p:plentyUsunietezZGlownego)
                        zbiorWszysktichJPanel.add(p);
                    plentyUsunietezZGlownego.clear();
                    for (Planet planet : planetyDoZamrozenia) {
                        planet.setStanAktualny(false);
                    }
                    sampleLampCheck();



                    myGameScrollablePanel.addPanelPass(testaddPanel(),"");
                    myGameScrollablePanel.addPanelPass(addPanelInfo(),"wrap");
                    probaLabel.setText(proba<counterRounds && (++proba) == 0 ? "" : "<html><b>Próba "+proba+"/"+counterRounds+"</b></html>");
                    reload();
                    whenWinGame();


                    //whenWinGame();
                }

            }
        });
        add(sprawdzButton);

        przerwijButton = new MyButton("Przerwij",28,163,570);
        przerwijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAndgoToLoginPanel();

            }
        });
        add(przerwijButton);

        probaLabel = new JLabel();
        probaLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        probaLabel.setBounds(70,415, 120,50);
        probaLabel.setForeground(Color.white);
        add(probaLabel);

        iconLevel = new JLabel();
        iconLevel.setBounds(215,400, 80,80);
        iconLevel.setOpaque(false);
        add(iconLevel);


        playerName = new JLabel("", SwingConstants.CENTER){
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
        playerName.setFont(new Font("Verdana", Font.PLAIN, 20));
        playerName.setBounds(34,35, 251,30);
        playerName.setOpaque(false);
        playerName.setBackground( new Color(116, 116, 116, 163) );
        playerName.setForeground(Color.white);
        add(playerName);


    }


    //Added Panels (Plantes, lamps)
    public static JPanel testaddPanel(){
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
    public static JPanel addPanelInfo(){
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
    //Check and sets Lampinfo
    public static boolean isCorectPasswrod(){
        int lenghOfPass = LoginPanel.password.size();
        if(lenghOfPass == planetyDoZamrozenia.size()){
            for(int i = 0; i<lenghOfPass; i++){
                if(!planetyDoZamrozenia.get(i).equals(LoginPanel.password.get(i))){
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    public static void setImageLampGroup(int correctPlanet, int contain){
        LampInfo[] lampGroup = new LampInfo[setPlanetDepdecyLevel()];

        for(int i=0; i<correctPlanet; i++){
            lampGroup[i] = new LampInfo(green_Lamp,35,25);
        }
        for(int i = correctPlanet ; i<contain;i++){
            lampGroup[i] = new LampInfo(red_Lamp,35,25);
        }
        for(int i = contain ; i<lampGroup.length;i++){
            lampGroup[i] = new LampInfo(empty_Lamp,35,25);
        }


        String wrap="";
        for(int i = 0 ; i < lampGroup.length;i++){
            if(lampGroup.length == 4)
                wrap = "wrap";
            else if(i%2!=0 && lampGroup.length > 4)
                wrap = "wrap";
            lampInfoPanel.add(lampGroup[i], wrap);
            wrap="";
        }

    }
    public static void sampleLampCheck(){
        ArrayList<Planet> pass = LoginPanel.password;
        ArrayList<Planet> samplePass = planetyDoZamrozenia;
        int correctPlanet = 0 , contain = 0;

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


        setImageLampGroup(correctPlanet,contain);

    }
    //Showing Level in GamePanel
    public static boolean showLevel(){
        if(selectedLevelString.equals("easy")) {
            iconLevel.setIcon(new javax.swing.ImageIcon(LevelGame.resize(easyOnIMG, 70, 70)));
            return true;
        }
        else if(selectedLevelString.equals("medium")){
            iconLevel.setIcon(new javax.swing.ImageIcon(LevelGame.resize(mediumOnIMG, 70, 70)));
            return true;
        }
        else if(selectedLevelString.equals("hard")){
            iconLevel.setIcon(new javax.swing.ImageIcon(LevelGame.resize(hardOnIMG, 70, 70)));
            return true;
        }
        return false;
    }
    // Referesh
    public static void reload(){
        lampInfoPanel.revalidate();
        lampInfoPanel.repaint();
        myGameScrollablePanel.revalidate();
        myGameScrollablePanel.repaint();
        zbiorWszysktichJPanel.revalidate();
        zbiorWszysktichJPanel.repaint();
        probaLabel.revalidate();
        probaLabel.repaint();
    }
    //Load plantes to GamePanel
    public static void loadStartPlanets(){
        ArrayList<Planet> allPlanets = LoginPanel.allPlanetsArrList;
        if(selectedLevelString.equals("easy")){
            for (int i = 0; i < allPlanets.size()-3; i++){
                Planet newPlanet = new Planet(allPlanets.get(i).getNamePlanet(),allPlanets.get(i).getImagePlanet(),50);
                newPlanet.addMouseListener(new PlanetListenerGame_GamePanel(newPlanet));
                zbiorWszysktichJPanel.add(newPlanet);
            }
        }else {
            for ( Planet planet: allPlanets) {
                Planet newPlanet = new Planet(planet.getNamePlanet(),planet.getImagePlanet(),50);
                newPlanet.addMouseListener(new PlanetListenerGame_GamePanel(newPlanet));
                zbiorWszysktichJPanel.add(newPlanet);
            }
        }
    }



    // reset method an go to LoginPanel
    public void resetAndgoToLoginPanel(){

        int confirm = JOptionPane.showConfirmDialog(this, "Czy na pewno ?", "Potwierdź", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            // czyszczebue list
            planetyDoZamrozenia.clear();
            myGameScrollablePanel.getMainPanelGame().removeAll();
            zbiorWszysktichJPanel.removeAll();
            password.clear();
            plentyUsunietezZGlownego.clear();
            isSamples = false;
            proba = 0 ;
            probaLabel.setText("");

            resetPlanets();
            setPanel(1);
        }


       // reload();


    }
    private void whenWinGame(){
        if(isCorectPasswrod()){
            winpanel = new WinGamePanel();
            try{
                Thread.sleep(500);
            }catch (InterruptedException ex){ }
            add(winpanel,0);
            reload();
            for (Component component : getComponents()) {
                component.setEnabled(false);
            }
            winpanel.reload();

        }else if(!isCorectPasswrod() && proba == counterRounds){
            add(losepanel,0);
            reload();
            for (Component component : getComponents()) {
                component.setEnabled(false);
            }
            losepanel.reload();
        }
        planetyDoZamrozenia.clear();
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