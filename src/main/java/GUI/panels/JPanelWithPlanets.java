package GUI.panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static GUI.panels.GamePanel.myGameScrollablePanel;


public class JPanelWithPlanets extends JPanel {

    public JPanelWithPlanets(){
        setBackground( new Color(32, 32, 32, 213) );
        setOpaque(false);
        setBounds(35, 85, 250, 300);
        setBorder(BorderFactory.createEmptyBorder());

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
