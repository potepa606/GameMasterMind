package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.MyButton;
import logic.JScrollablePanel;
import net.miginfocom.swing.MigLayout; // If you're just using this one class

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.levelModuleListeners.LevelGame.stateMedium;
import static GUI.panels.StartPanel.backgound;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static logic.LoadComponents.red_image;


public class GamePanel extends JPanel {

    JScrollablePanel myGameScrollablePanel = new JScrollablePanel();

    public GamePanel( ) {
        setLayout(null);
        add(myGameScrollablePanel);

        JButton testBut = new MyButton("test",30,80,50);
        testBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myGameScrollablePanel.addPanelPass(testaddPanel());
            }
        });
        add(testBut);
    }

    public static JPanel testaddPanel(){
        JPanel testPanel  = new JPanel(){
          protected void paintComponent(Graphics g)
          {   //Set full transparency background
              super.paintComponent(g);
              g.setColor( getBackground() );
              g.fillRect(0, 0, getWidth(), getHeight());
          }
        };
        testPanel.setLayout(new MigLayout("alignx center"));
        testPanel.setForeground(Color.BLACK);
        testPanel.setBounds(0, 0, 70, 70);
        testPanel.setOpaque(true);
        testPanel.setBackground( new Color(255, 255, 255, 0) );
        testPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.lightGray),"<html><font color='white'>test</font></html>"));

        JLabel testLabel = new JLabel("<html><b>TEST</b></html>",  SwingConstants.CENTER);
        testLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
        testLabel.setForeground(Color.WHITE);

        JPanel mediumStatePanel = new JPanel(){
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);

                stateMedium = LevelGame.resize(red_image,100,100);
                g.drawImage(stateMedium, 0, 0, this);

            }
        };
        mediumStatePanel.setPreferredSize(new Dimension(100,100));
        mediumStatePanel.setOpaque(false);
        mediumStatePanel.setBackground( new Color(255, 255, 255, 0) );
        mediumStatePanel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getClickCount());
            }
        });
        testPanel.add(mediumStatePanel);


        return testPanel;
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
