package GUI.mainFrame;


import database.DataBaseAction;
import managePanels.Managment;
import music.Music;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class MainWindow extends JFrame {


    List<JPanel> panels = Managment.panels;

    public MainWindow()  {
        add(panels.get(0));
        setLocation(600, 0);
        setTitle("Master Mind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);

        Music music = new Music();
        music.getClip().start();

    }


    public void setFavIcon(){
        File logoPath = new File("src\\main\\java\\GUI\\images\\mIcon.png");
        ImageIcon img = new ImageIcon(logoPath.getAbsolutePath());
        setIconImage(img.getImage());
    }





}
