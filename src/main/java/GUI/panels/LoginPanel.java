package GUI.panels;

import GUI.levelModuleListeners.EasyChangeListener;
import GUI.levelModuleListeners.HardChangeListener;
import GUI.levelModuleListeners.LevelGame;
import GUI.levelModuleListeners.MediumChangeListener;
import GUI.panels.listeners.PlanetsListeners;
import GUI.styles.MyButton;
import logic.Planet;
import logic.Planets;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GUI.levelModuleListeners.LevelGame.*;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static managePanels.Managment.setPanel;
import static logic.LoadComponents.*;


public class LoginPanel extends JPanel  {

    private JPanel typeGamePanel;
    private JPanel settingsOfGame;
    public static JPanel passworPanel, ballsPanel;

    private JLabel vsComputerLabel,secondPlayerLabel;
    private JTextField secondPlayerName;
    private JCheckBox isMultiPlayer;

    private JLabel rounds;
    private static short counterRounds=2;


    public static JPanel easyStatePanel ,mediumStatePanel, hardStatePanel;
    public static ArrayList<Planet> allPlanetsArrList = new ArrayList<Planet>();
    public static ArrayList<Planet> password = new ArrayList<Planet>();



    static {
        for (Planets planet:Planets.values()) {
            Planet p = planet.getPlanet();
            p.setSize(20);
            p.setFontTitle(9);
            p.addMouseListener(new PlanetsListeners(p));
            allPlanetsArrList.add(p);
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH.getSize(),WINDOW_HEIGHT.getSize());
    }

    public LoginPanel(){
        setLayout(null);
        typeGamePanel = new JPanel(){
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
        typeGamePanel.setBounds(35, 200, 355, 465);
        typeGamePanel.setLayout(null);
        typeGamePanel.setOpaque(false);
        typeGamePanel.setBackground( new Color(32, 32, 32, 213) );
        add(typeGamePanel);

        settingsOfGame = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(20,20);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
            }
        };
        settingsOfGame.setBounds(460, 200, 355, 400);
        settingsOfGame.setLayout(null);
        settingsOfGame.setOpaque(false);
        settingsOfGame.setBackground( new Color(32, 32, 32, 213) );
        add(settingsOfGame);


        body_typeGamePanel();
        body_settingsOfGame();


        add(body_buttonsPanel());

    }
    private void body_typeGamePanel(){

        // WIDTH = 355; HEIGHT = 465
        typeGamePanel.add(dodajLabel("<font color='white'>Rodzaj Gry</font>", (355/2)-60,50,15));

        isMultiPlayer = new JCheckBox("<html><font color='white'><b> Multiplayer </b></font></html>" ,false);
        isMultiPlayer.setBounds(48,150, 120,50);
        isMultiPlayer.setFont(new Font("Verdana", Font.PLAIN, 15));
        isMultiPlayer.setOpaque(false);
        isMultiPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isMultiPlayer.isSelected()){
                    secondPlayerLabel.setVisible(true);
                    secondPlayerName.setVisible(true);
                    vsComputerLabel.setVisible(false);

                }else {
                    secondPlayerLabel.setVisible(false);
                    secondPlayerName.setVisible(false);
                    secondPlayerName.setText("");
                    vsComputerLabel.setVisible(true);
                }

            }
        });
        typeGamePanel.add(isMultiPlayer);

        typeGamePanel.add(dodajLabel(" <font color='white'>Gracz 1:</font> ", 20,210,12));
        typeGamePanel.add(dodajTexFiled(140, 212,180, 26));

        typeGamePanel.add(dodajLabel(" <font color='white'>VS</font> ", (355/2)-60,280,16));

        vsComputerLabel = dodajLabel(" <font color='white'>Komputer</font> ", (355/2)-60,350,16);
        typeGamePanel.add(vsComputerLabel);

        secondPlayerLabel = dodajLabel(" <font color='white'>Gracz 2:</font> ", 20,350,12);
        secondPlayerLabel.setVisible(false);
        typeGamePanel.add(secondPlayerLabel);
        secondPlayerName = dodajTexFiled(140, 352,180, 26);
        secondPlayerName.setVisible(false);
        typeGamePanel.add(secondPlayerName);




    }
    private void body_settingsOfGame(){

        // WIDTH = 355; HEIGHT = 465
        //settingsOfGame.add(dodajLabel(" <html><font color='white'>Ustawienia</font></html> ", (355/2)-60,50,15));
        settingsOfGame.add(body_samplePanel());
        settingsOfGame.add(body_levelPanel());
        settingsOfGame.add(body_ballsPanel());
        settingsOfGame.add(body_passwordPanel());

    }
    // Right Panel
    private JPanel body_levelPanel(){

        JPanel levelsPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        levelsPanel.setLayout(null);
        levelsPanel.setBounds(52, 30, 250, 100);
        levelsPanel.setOpaque(false);
        levelsPanel.setBackground( new Color(255, 255, 255, 0) );
        //levelsPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK),"<html><font color='white'>Poziom</font></html>"));

        ////////////////////////////////////////////////////////////// Pod Panele Levels
        easyStatePanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
                stateEasy = LevelGame.resize(LevelGame.easyIMG,70,70);
                g.drawImage(stateEasy, 0, 0, this);
            }
        };
        easyStatePanel.setBounds(10, 20, 70, 70);
        easyStatePanel.setOpaque(false);
        easyStatePanel.setBackground( new Color(255, 255, 255, 0) );
        easyStatePanel.addMouseListener(new EasyChangeListener());
        levelsPanel.add(easyStatePanel);

        mediumStatePanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
                stateMedium = LevelGame.resize(mediumIMG,70,70);
                g.drawImage(stateMedium, 0, 0, this);

            }
        };
        mediumStatePanel.setBounds(90, 20, 70, 70);
        mediumStatePanel.setOpaque(false);
        mediumStatePanel.setBackground( new Color(255, 255, 255, 0) );
        mediumStatePanel.addMouseListener(new MediumChangeListener());
        levelsPanel.add(mediumStatePanel);

        hardStatePanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
                stateHard = LevelGame.resize(hardIMG,70,70);
                g.drawImage(stateHard, 0, 0, this);
            }
        };
        hardStatePanel.setBounds(170, 20, 70, 70);
        hardStatePanel.setOpaque(false);
        hardStatePanel.setBackground( new Color(255, 255, 255, 0) );
        hardStatePanel.addMouseListener(new HardChangeListener());
        levelsPanel.add(hardStatePanel);


        return levelsPanel;
    }
    private JPanel body_samplePanel(){


        JPanel samplePanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        //  passworPanel.setLayout(null);
        samplePanel.setBounds(50, 140, 255, 50);
        samplePanel.setOpaque(false);
        samplePanel.setBackground( new Color(255, 255, 255, 0) );
        //samplePanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'></font></html>"));
        samplePanel.add(dodajLabel(" <html><font color='white'>Ilość prób:</font></html> ", 20,210,15));




        MyButton minusRound = new MyButton("-",10,150,215);
        minusRound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(counterRounds > 1){
                    counterRounds--;
                    rounds.setText("<html><font color='white'><b>"+counterRounds+"</b></font></html>");
                }
            }
        });
        samplePanel.add(minusRound);

        rounds = dodajLabel("<html><font color='white'><b>"+counterRounds+"</b></font></html>" ,148, 209,17 );
        samplePanel.add(rounds);

       MyButton plusRound = new MyButton("+",10,235,212);
        plusRound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(counterRounds < 10) {
                    counterRounds++;
                    rounds.setText("<html><font color='white'><b>"+counterRounds+"</b></font></html>");
                }
            }
        });
        samplePanel.add(plusRound);

        return samplePanel;
    }
    private JPanel body_ballsPanel(){
        ballsPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {   //Set full transparency background
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        ballsPanel.setOpaque(false);
        ballsPanel.setBackground( new Color(255, 255, 255, 0) );
        ballsPanel.setBounds(50, 190, 255, 110);
        ballsPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>Wszystkie kule</font></html>"));

        for (Planet planet: allPlanetsArrList) {
            ballsPanel.add(planet);
        }


        return ballsPanel;
    }
    private JPanel body_passwordPanel(){
        passworPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        passworPanel.setBounds(50, 300, 255, 80);
        passworPanel.setOpaque(false);
        passworPanel.setBackground( new Color(255, 255, 255, 0) );
        passworPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>Haslo</font></html>"));
        return passworPanel;
    }
    private JPanel body_buttonsPanel(){

        JPanel buttonsPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        buttonsPanel.setLayout(new GridLayout(1,2,30,40));
        buttonsPanel.setBounds(480, 620, 320, 40);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBackground( new Color(255, 255, 255, 0) );
        //buttonsPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>buttons</font></html>"));


        JButton backButtonPanel = new MyButton("Back",30,10,10);
        buttonsPanel.add(backButtonPanel);
        backButtonPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(0);
            }
        });
        JButton startGameButton = new MyButton("Start",30,10,10);
        buttonsPanel.add(startGameButton);
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(password.size() >=4) {
                   GamePanel.loadStartPlanets();
                   setPanel(2);
               }
            }
        });


        return buttonsPanel;
    }

    //Left Panel



    public JLabel dodajLabel(String text, int x, int y, int size){
        JLabel jLabel = new JLabel("<html><b> "+text+" </b></html>",  SwingConstants.CENTER);
        jLabel.setFont(new Font("Verdana", Font.PLAIN, size));
        //jLabel.setBorder(new LineBorder(Color.BLACK));
        jLabel.setBounds(x, y, 120, 30);
        jLabel.setForeground(Color.BLACK);
        return jLabel;
    }
    public JTextField dodajTexFiled(int x, int y, int sizeX, int sizeY){
        JTextField jTextField = new JTextField();
        jTextField.setBounds(x, y, sizeX, sizeY);
        jTextField.setBorder(new LineBorder(Color.BLACK));
        add(jTextField);
        return jTextField;
    }

    public static void setPlanetDepdecyLevel(){

        if(pokazstany().equals("Easy")){


        }


    }

    public static void reload(){
        passworPanel.revalidate();
        passworPanel.repaint();

        ballsPanel.revalidate();
        ballsPanel.repaint();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(StartPanel.backgound, 0, 0, this); // see javadoc for more info on the parameters
        g.drawImage(StartPanel.headerImage, 60, 0, this); // see javadoc for more info on the parameters
    }

}