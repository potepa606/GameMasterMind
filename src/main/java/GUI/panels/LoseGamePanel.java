package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.MyButton;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.panels.GamePanel.*;
import static GUI.panels.LoginPanel.*;
import static managePanels.Managment.*;

public class LoseGamePanel extends JPanel {


    public LoseGamePanel() {
        setLayout(null);
        setBackground( new Color(13, 13, 13, 234) );
        setBounds(25, 70, 800, 350);
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(false);



        Image image = Toolkit.getDefaultToolkit().createImage("e:\\C_School\\GameMasterMind\\src\\main\\java\\GUI\\images\\giffs\\end.gif");
        Icon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        label.setBounds(150,0,500,300);
        add(label);


        MyButton repeat = new MyButton("Try Again",25,1,1);
        repeat.setBounds(295,300,200,40);
        add(repeat);
        repeat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // czyszczebue list
                planetyDoZamrozenia.clear();
                myGameScrollablePanel.getMainPanelGame().removeAll();
                zbiorWszysktichJPanel.removeAll();
                password.clear();
                plentyUsunietezZGlownego.clear();
                isSamples = false;
                proba = 0 ;
                probaLabel.setText("");


               // GamePanel.reload();

                resetPlanets();
                setPanel(1);

                panels.get(2).remove(0);
                for (Component component : panels.get(2).getComponents()) {
                    component.setEnabled(true);
                }
            }
        });



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
