package GUI.panels;

import GUI.levelModuleListeners.EasyChangeListener;
import GUI.levelModuleListeners.HardChangeListener;
import GUI.levelModuleListeners.LevelGame;
import GUI.levelModuleListeners.MediumChangeListener;
import GUI.panels.listeners.PlanetsListeners_LoginPanel;
import GUI.styles.MyButton;
import logic.LoadComponents;
import logic.Planet;
import logic.Planets;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static GUI.levelModuleListeners.LevelGame.*;
import static GUI.panels.GamePanel.*;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static logic.LoadComponents.*;
import static managePanels.Managment.setPanel;


public class LoginPanel extends JPanel  {

    private JPanel typeGamePanel;
    private JPanel settingsOfGame;

    public static JTextField playerName;

    private JLabel rounds;
    public static short counterRounds=2;
    public static boolean isSamples = false;

    public static JLabel easyStatePanel ,mediumStatePanel, hardStatePanel;
    public static JPanel passworPanel, ballsPanel;


    public static ArrayList<Planet> allPlanetsArrList = new ArrayList<Planet>();
    public static ArrayList<Planet> password = new ArrayList<Planet>();

    static {
        ToolTipManager.sharedInstance().setInitialDelay(50);
        ToolTipManager.sharedInstance().setDismissDelay(1000);
        ToolTipManager.sharedInstance().isLightWeightPopupEnabled();

        for (Planets planet:Planets.values()) {
            Planet p = planet.getPlanet();
            p.setSize(20);
            p.setFontTitle(9);
            p.addMouseListener(new PlanetsListeners_LoginPanel(p));
            allPlanetsArrList.add(p);
        }
        System.out.println(" ilosc planet "  +allPlanetsArrList.size());
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


        body_typeGamePanel(); // adds left components
        body_settingsOfGame(); // adds right components
        add(body_buttonsPanel()); // adds buttons start and back

    }




    // Left Panel
    // Componets to left Panel
    private void body_typeGamePanel(){

        // WIDTH = 355; HEIGHT = 465
        typeGamePanel.add(dodajLabel("<font color='white'>Rejestracja</font>", (355/2)-60,50,15));


        typeGamePanel.add(dodajLabel(" <font color='white'>Player:</font> ", 20,100,12));
        playerName = dodajTexFiled(140, 102,180, 26);
        playerName.setText("Krzysztof");
        playerName.selectAll();
        playerName.setFont(new Font("Courier", Font.BOLD,12));
        playerName.setHorizontalAlignment(JTextField.CENTER);
        playerName.setBackground(new Color(45, 45, 45, 208));
        playerName.setForeground(Color.white);
        playerName.setCaretColor(Color.WHITE);
        playerName.setOpaque(false);
        playerName.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE)));
        typeGamePanel.add(playerName);


        JLabel randomIcon = new JLabel();
        randomIcon.setBounds(130,150,100,130);
        randomIcon.setText("<html><b> <font color='white'>Losuj układ</font></b></html>");
        //randomIcon.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE)));
        randomIcon.setFont(new Font("Courier", Font.BOLD,12));
        randomIcon.setIcon(new ImageIcon(LevelGame.resize(LoadComponents.randomIcon, 100, 100)));
        randomIcon.setHorizontalTextPosition(JLabel.CENTER);
        randomIcon.setVerticalTextPosition(JLabel.BOTTOM);
        randomIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                passworPanel.removeAll();
                passworPanel.revalidate();
                passworPanel.repaint();
                password.clear();
               if(password.size() < setPlanetDepdecyLevel())
                   randomPlanets();

                reload();
                for (Planet p : password) {
                    System.out.println(p.getNamePlanet());
                }
                //System.out.println("Ilosc planet w Jpanel " + passworPanel.getComponentCount());


            }
        });
        typeGamePanel.add(randomIcon);




    }


    // Right Panel
    //Levels module sets
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

        ////////////////////////////////////////////////////////////// Pod Panele Levels
        easyStatePanel = new JLabel();
        easyStatePanel.setBounds(10, 20, 70, 70);
        easyStatePanel.setIcon(new ImageIcon(LevelGame.resize(easyIMG,70,70)));
        easyStatePanel.setToolTipText("<html>Układ planet składajacy się z 4 ciał niebieskich.<br>Nie mogą się powtarzać</html>");
        easyStatePanel.addMouseListener(new EasyChangeListener());
        levelsPanel.add(easyStatePanel);


        mediumStatePanel = new JLabel();
        mediumStatePanel.setBounds(90, 20, 70, 70);
        mediumStatePanel.setIcon(new ImageIcon(LevelGame.resize(mediumIMG,70,70)));
        mediumStatePanel.setToolTipText("<html>Układ planet składajacy się z 4 ciał niebieskich.<br>Objekt może się raz powtózyć</html>");
        mediumStatePanel.addMouseListener(new MediumChangeListener());
        levelsPanel.add(mediumStatePanel);

        hardStatePanel = new JLabel();
        hardStatePanel.setBounds(170, 20, 70, 70);
        hardStatePanel.setIcon(new ImageIcon(LevelGame.resize(hardIMG,70,70)));
        hardStatePanel.addMouseListener(new HardChangeListener());
        levelsPanel.add(hardStatePanel);


        return levelsPanel;
    }
    // Module with samples sets
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
        samplePanel.add(dodajLabel(" <html><font color='white'>Ilość prób:</font></html> ", 20,210,15));



        MyButton minusRound = new MyButton("-",10,150,215);
        minusRound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(counterRounds > 1){
                    counterRounds--;
                    rounds.setText("<html><font color='white'><b>"+counterRounds+"</b></font></html>");
                    isSamples = true;
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
                    isSamples = true;
                }
            }
        });
        samplePanel.add(plusRound);

        return samplePanel;
    }
    // All Planets
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
        ballsPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>Wszystkie planety</font></html>"));

        for (Planet planet: allPlanetsArrList) {
            ballsPanel.add(planet);
        }


        return ballsPanel;
    }
    // Panel with password Planets
    private JPanel body_passwordPanel(){
        passworPanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        passworPanel.setBounds(11, 300, 330, 80);
        passworPanel.setOpaque(false);
        passworPanel.setBackground( new Color(255, 255, 255, 0) );
        passworPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>Hasło</font></html>"));
        return passworPanel;
    }
    // adds aboves methods to Panel
    private void body_settingsOfGame(){

        // WIDTH = 355; HEIGHT = 465
        //settingsOfGame.add(dodajLabel(" <html><font color='white'>Ustawienia</font></html> ", (355/2)-60,50,15));
        settingsOfGame.add(body_samplePanel());
        settingsOfGame.add(body_levelPanel());
        settingsOfGame.add(body_ballsPanel());
        settingsOfGame.add(body_passwordPanel());

    }


    // Buttons Start and Back
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

               if( warningWindows() && warningSetSamples() &&  GamePanel.showLevel() ) {
                   GamePanel.loadStartPlanets();
                   myGameScrollablePanel.addPanelPass(testaddPanel(),"");
                   myGameScrollablePanel.addPanelPass(addPanelInfo(),"wrap");
                   setPanel(2);
                   GamePanel.reload();
               }
            }
        });


        return buttonsPanel;
    }
    // return counter plantes dependecy level chosen
    public static int setPlanetDepdecyLevel(){
        if(selectedLevelString.equals("easy")){
            return 4;
        }else if(selectedLevelString.equals("medium")){
            return 4;
        }else if(selectedLevelString.equals("hard")){
            return 5;
        }
        return 0;
    }
    // warning when level is incorect with count plantes
    public  boolean warningWindows(){
        if(setPlanetDepdecyLevel() != password.size()){
            JOptionPane.showMessageDialog(this, "Liczba Planet jest niezgodna z levelem","Błąd",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else
            return true;
    }
    // warning when didnt set samples
    public  boolean warningSetSamples(){
        if(!isSamples){
            JOptionPane.showMessageDialog(this, "Ustaw liczbę prób","Błąd",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else
            return true;
    }

    //Lottery Planet
    public static void randomPlanets(){

        Planet  randomPlanet;
        System.out.println("level ilosc planet "   +setPlanetDepdecyLevel());
        int rozmiarHasla = setPlanetDepdecyLevel();
        Planet p;
        int i =0;
        while (true) {
            double rand = Math.random() * allPlanetsArrList.size();
            randomPlanet = Planets.values()[(int)rand].getPlanet();
             p = new Planet(randomPlanet.getNamePlanet(),randomPlanet.getImagePlanet());

            if(!password.contains(p)){
                password.add(p);
                passworPanel.add(new Planet("",questMark,randomPlanet.getSizes()+10));
            }

            if(rozmiarHasla == password.size())
                break;
        }
    }



    //Reset password Planets
    public static void resetPlanets(){
        ballsPanel.removeAll();
        if(selectedLevelString.equals("easy")){
            for (int i = 0; i < allPlanetsArrList.size()-3; i++)
                ballsPanel.add(allPlanetsArrList.get(i));
        }else {
            for (Planet planet: allPlanetsArrList)
                ballsPanel.add(planet);
        }
        passworPanel.removeAll();
        password.clear();
        reload();
    }



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


    public static void reload(){
        passworPanel.revalidate();
        passworPanel.repaint();
        ballsPanel.revalidate();
        ballsPanel.repaint();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgound, 0, 0, this); // see javadoc for more info on the parameters
        g.drawImage(headerImage, 60, 0, this); // see javadoc for more info on the parameters
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH.getSize(),WINDOW_HEIGHT.getSize());
    }

}