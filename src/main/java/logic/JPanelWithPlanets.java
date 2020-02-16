package logic;
import javax.swing.*;
import java.awt.*;




public class JPanelWithPlanets extends JPanel {

    public JPanelWithPlanets(){
        setOpaque(false);
       // planetsPanel.setLayout( new MigLayout("alignx center"));
        setBackground( new Color(32, 32, 32, 213) );

       // setViewportView(planetsPanel);
       // setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      //  setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setOpaque(false);
        setBounds(35, 35, 250, 300);
        setBorder(BorderFactory.createEmptyBorder());
        //getViewport().setBackground(new Color(255, 255, 255, 0));
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
