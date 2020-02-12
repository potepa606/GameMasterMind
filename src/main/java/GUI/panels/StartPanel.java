package GUI.panels;

import GUI.styles.MyButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static GUI.widnowsSize.Size.WINDOW_HEIGHT;
import static GUI.widnowsSize.Size.WINDOW_WIDTH;
import static managePanels.Managment.setPanel;


public class StartPanel extends JPanel {

    public static BufferedImage headerImage, backgound;




    public StartPanel(){
        setLayout(null);

        try {
            File headerPathLogo= new File("src\\main\\java\\GUI\\images\\background\\header.png");
            headerImage = ImageIO.read(headerPathLogo);

            File bgPath= new File("src\\main\\java\\GUI\\images\\background\\space_background.jpg");
            backgound = ImageIO.read(bgPath);
        } catch (IOException ex) {
            System.out.println(ex);
        }

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
//                mainWwindow.add(Managment.panels.get(1));
//                panels.get(0).setVisible(false);
            }
        });
        add(rankingButton);
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
