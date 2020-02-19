package GUI.panels;
import GUI.levelModuleListeners.LevelGame;
import net.miginfocom.swing.MigLayout; // If you're just using this one class
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;

import static GUI.panels.GamePanel.myGameScrollablePanel;
import static logic.LoadComponents.down;
import static logic.LoadComponents.up;


public class JScrollablePanel extends JScrollPane {

    public JPanel mainPanelGame ;


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
        mainPanelGame.setBackground( new Color(32, 32, 32, 213) );

        setViewportView(mainPanelGame);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setOpaque(false);
        // h- 635
        setBounds(300, 25, 535, 635);
        setBorder(BorderFactory.createEmptyBorder());
        getViewport().setBackground(new Color(255, 255, 255, 0));


        //setComponentZOrder(getVerticalScrollBar(), 0);
        //setComponentZOrder(getViewport(), 1);
        getVerticalScrollBar().setOpaque(false);


        setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollPane = (JScrollPane)parent;

                Rectangle availR = scrollPane.getBounds();
                availR.x = availR.y = 0;

                Insets insets = parent.getInsets();
                availR.x = insets.left;
                availR.y = 60;
                availR.width  -= insets.left + insets.right;
                availR.height -= insets.top  + insets.bottom+120;

                Rectangle vsbR = new Rectangle();
                vsbR.width  = 515;
                vsbR.height = availR.height+110;
                vsbR.x = 10;
                vsbR.y = availR.y-55;

                if(viewport != null) {
                    viewport.setBounds(availR);
                }
                if(vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });
        final Thread[] przewijanie = new Thread[2];
        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private final Dimension d = new Dimension(0,50);
            @Override protected JButton createDecreaseButton(int orientation) {
                JButton upButton = new JButton(){
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
                upButton.setIcon(new javax.swing.ImageIcon(LevelGame.resize(up, 35, 40)));
                upButton.setBackground( new Color(32, 32, 32, 213) );
                upButton.setFocusPainted(false);
                upButton.setPreferredSize(d);
                upButton.setOpaque(false);
                upButton.setContentAreaFilled(false);
                upButton.setBorder(BorderFactory.createEmptyBorder());
                upButton.setForeground(Color.white);
                upButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        przewijanie[0] = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    myGameScrollablePanel.getVerticalScrollBar().setValue(myGameScrollablePanel.getVerticalScrollBar().getValue() - 30);
                                    sleep(100);
                                }
                            }
                        });
                        przewijanie[0].start();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        przewijanie[0].stop();
                    }
                });
                return upButton;
            }

            @Override protected JButton createIncreaseButton(int orientation) {
                JButton downButton = new JButton(){
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
                downButton.setIcon(new javax.swing.ImageIcon(LevelGame.resize(down, 35, 40)));
                downButton.setFocusPainted(false);
                downButton.setBackground( new Color(32, 32, 32, 213) );
                downButton.setPreferredSize(d);
                downButton.setOpaque(false);
                downButton.setContentAreaFilled(false);
                downButton.setBorder(BorderFactory.createEmptyBorder());
                downButton.setForeground(Color.white);
                downButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        przewijanie[1] = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    myGameScrollablePanel.getVerticalScrollBar().setValue(myGameScrollablePanel.getVerticalScrollBar().getValue() +  30);
                                    sleep(100);
                                }
                            }
                        });
                        przewijanie[1].start();
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        przewijanie[1].stop();
                    }
                });
                return downButton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {}
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                Color color = null;
                JScrollBar sb = (JScrollBar)c;
                if(!sb.isEnabled() || r.width>r.height) {
                    return;
                }else if(isDragging) {
                    color = new Color(255, 255, 128, 0);
                }else if(isThumbRollover()) {
                    color = new Color(255,255,100, 0);
                }else {
                    color = new Color(255, 255, 233, 0);
                }
                g2.setPaint(color);
                g2.fillRoundRect(r.x,r.y,r.width,r.height,10,10);
                g2.setPaint(Color.WHITE);
                g2.drawRoundRect(r.x,r.y,r.width,r.height,10,10);
                g2.dispose();
            }
            @Override
            protected void setThumbBounds(int x, int y, int width, int height) {
                super.setThumbBounds(x, y, width, height);
                scrollbar.repaint();
            }
        });



    }

    public JPanel getMainPanelGame() {
        return mainPanelGame;
    }


    public void addPanelPass(JPanel addPanel, String  how){
        mainPanelGame.add(addPanel, how);
        getViewport().revalidate();
        getViewport().repaint();
    }


    public static void sleep(int milisec){
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
