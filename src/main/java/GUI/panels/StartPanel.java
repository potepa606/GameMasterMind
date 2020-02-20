package GUI.panels;

import GUI.levelModuleListeners.LevelGame;
import GUI.styles.CustomListRenderer;
import GUI.styles.MyButton;
import database.DataBaseAction;
import logic.Player;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static GUI.panels.GamePanel.myGameScrollablePanel;
import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static logic.LoadComponents.*;
import static logic.LoadComponents.down;
import static managePanels.Managment.setPanel;


public class StartPanel extends JPanel {



    public static DefaultListModel modelPlayersList = new DefaultListModel();
    public StartPanel(){
        setLayout(null);

        MyButton startButton = new MyButton("START",50,WINDOW_WIDTH.getSize()/2,WINDOW_HEIGHT.getSize()/2);
        startButton.setForeground(Color.orange);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(1);
            }




        });
        add(startButton);


        MyButton rankingButton = new MyButton("Ranking",25,WINDOW_WIDTH.getSize()/2,(WINDOW_HEIGHT.getSize()/2)+100);
        rankingButton.setForeground(Color.orange);
        rankingButton.setFont(new Font("Monospaced", Font.ROMAN_BASELINE, 25));
        rankingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelPlayersList.clear();
                DataBaseAction.loadPlayers();

                JPanel rankingPanel = rankingPanel();
                add(rankingPanel,0);
                reload();
                for (Component component : getComponents()) {
                    component.setEnabled(false);
                }
            }
        });
        add(rankingButton);
    }


    public JPanel rankingPanel() {
        JPanel rankingPanel = new JPanel() {
            protected void paintComponent(Graphics g) {   //Set full transparency background
                super.paintComponent(g);
                Dimension arcs = new Dimension(20, 20);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(getForeground());
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
            }

        };
        rankingPanel.setLayout(null);
        rankingPanel.setBackground(new Color(13, 13, 13, 234));
        rankingPanel.setBounds(25, 130, 800, 350);
        rankingPanel.setBorder(BorderFactory.createEmptyBorder());
        rankingPanel.setOpaque(false);

        MyButton zamknijButton = new MyButton("Zamknij", 23, 390, 300);
        rankingPanel.add(zamknijButton);
        zamknijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getComponent(0).setVisible(false);
                getComponent(0).setEnabled(false);
                for (Component component : getComponents()) {
                    component.setEnabled(true);
                }
                reload();
            }
        });


        for (Player player : Player.listOfPlayers) {
            modelPlayersList.addElement(player);
        }


        JList<String> list = new JList(modelPlayersList);
        list.setCellRenderer(new CustomListRenderer(list));
        list.setBorder(BorderFactory.createEmptyBorder());


        JScrollPane scrollPane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setComponentZOrder(scrollPane.getVerticalScrollBar(), 0);
        scrollPane.setComponentZOrder(scrollPane.getViewport(), 1);
        scrollPane.getVerticalScrollBar().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());




        scrollPane.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollPane = (JScrollPane)parent;

                Rectangle availR = scrollPane.getBounds();
                availR.x = availR.y = 0;

                Insets insets = parent.getInsets();
                availR.x = insets.left;
                availR.y = insets.top;
                availR.width  -= insets.left + insets.right+20;
                availR.height -= insets.top  + insets.bottom;

                Rectangle vsbR = new Rectangle();
                vsbR.width  = 20;
                vsbR.height = availR.height;
                vsbR.x = availR.x + availR.width - vsbR.width+20;
                vsbR.y = availR.y;

                if(viewport != null) {
                    viewport.setBounds(availR);
                }
                if(vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private final Dimension d = new Dimension();
            @Override protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
            }
            @Override protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                    @Override public Dimension getPreferredSize() {
                        return d;
                    }
                };
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
                    color = new Color(70, 70, 70,200);
                }else if(isThumbRollover()) {
                    color = new Color(70, 70, 70,200);
                }else {
                    color =  new Color ( 82, 158, 202 );
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


        scrollPane.setBounds(100,30,600,240);


        rankingPanel.add(scrollPane);

        return rankingPanel;

    }


    private void reload(){
        this.revalidate();
        this.repaint();
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WINDOW_WIDTH.getSize() ,WINDOW_HEIGHT.getSize());
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgound, 0, 0, this); // see javadoc for more info on the parameters
        g.drawImage(headerImage, 60, 0, this); // see javadoc for more info on the parameters
    }

}
