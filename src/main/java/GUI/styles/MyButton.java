package GUI.styles;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {


    public MyButton(String name, int size,int x,int y) {
        setText("<html><b>"+ name +"</b></html>");
        setFont(new Font("Monospaced", Font.PLAIN, size));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(new Color(0xff0044));
        setForeground(Color.white);
        setUI(new StyledButton());

        int sizeOfName = name.length();
        int width  = (size * sizeOfName)+10;
        int height  = size+sizeOfName;
        setBounds(x-(width/2), y-(height/2), width, height);
    }


}