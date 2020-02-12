package logic;
import net.miginfocom.swing.MigLayout; // If you're just using this one class
import javax.swing.*;
import java.awt.*;

public class JScrollablePanel extends JScrollPane {

    private JPanel mainPanelGame = null;

    public JScrollablePanel(){

        this.mainPanelGame = new JPanel(){
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
        mainPanelGame.setOpaque(false);
        mainPanelGame.setLayout( new MigLayout("alignx center"));
        // mainPanelGame.setPreferredSize(new Dimension( 400,640));
        mainPanelGame.setBackground( new Color(32, 32, 32, 213) );

        setViewportView(mainPanelGame);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setOpaque(false);
        setBounds(330, 35, 505, 635);
        setBorder(BorderFactory.createEmptyBorder());
        getViewport().setBackground(new Color(255, 255, 255, 0));
    }

    public void addPanelPass(JPanel addPanel){
        mainPanelGame.add(addPanel, "wrap");
        getViewport().revalidate();
        getViewport().repaint();
    }




}
