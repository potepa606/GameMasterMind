package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.MyButton;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static logic.LoadComponents.earth100;
import static logic.LoadComponents.earth50;


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
