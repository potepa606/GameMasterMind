package GUI.panels;

import GUI.styles.MyButton;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.levelModuleListeners.LevelGame.selectedLevelString;
import static GUI.panels.GamePanel.*;
import static GUI.panels.GamePanel.probaLabel;
import static GUI.panels.LoginPanel.*;
import static database.DataBaseAction.sendPlayers;
import static managePanels.Managment.panels;
import static managePanels.Managment.setPanel;

public class WinGamePanel extends JPanel {

    private Player player ;



    public WinGamePanel() {
        setLayout(null);
        setBackground( Color.black);
        setBounds(25, 70, 800, 400);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);

        Image image = Toolkit.getDefaultToolkit().createImage("e:\\C_School\\GameMasterMind\\src\\main\\java\\GUI\\images\\giffs\\win.gif");
        Icon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        label.setBounds(150,0,500,300);
        add(label);


        this.player = new Player(LoginPanel.playerName.getText(),proba,selectedLevelString);
        String wynik = "Gratulacje!!! Twój wynik ";
        String score = " " + this.player.getWynik();
        JLabel wynikLabel = new JLabel("<html><b>" + wynik + score + "</b></html>");
        wynikLabel.setBounds(250,300,400,30);
        wynikLabel.setForeground(Color.YELLOW);
        wynikLabel.setFont(new Font("Verdana", Font.PLAIN, 20));

        add(wynikLabel);

        MyButton repeat = new MyButton("Save and exit",25,1,1);
        repeat.setBounds(260,340,300,40);
        add(repeat);
        repeat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendPlayrScoreToDatabase();
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
                setPanel(0);
                panels.get(2).remove(0);
                for (Component component : panels.get(2).getComponents()) {
                    component.setEnabled(true);
                }
            }
        });



    }

    private void sendPlayrScoreToDatabase(){
        sendPlayers(this.player);
    }


    public void reload(){
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
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
}
