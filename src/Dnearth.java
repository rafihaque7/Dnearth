import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by rafihaque on 6/23/17.
 */
public class Dnearth {
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame("Day and Night Earth");   //Sets the frame title, which is up top
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //It exits if you close it
        Container pane = frame.getContentPane();    //Sets the content of the frame
        pane.setLayout(new BorderLayout());    //The top will be the map, and underneath will be buttons



        Peach p = new Peach();
        p.setPreferredSize(new Dimension(1400,700));
        pane.add(p,BorderLayout.PAGE_START);    //Up top




        JPanel undPanel = new JPanel();
        undPanel.setLayout(new GridLayout(1,7));

        JLabel hintLabel = new JLabel("Type in the Time: ");

        JTextField monthField = new JTextField("Month");
        JTextField dayField = new JTextField("Day");
        JTextField yearField = new JTextField("Year");


        JTextField hourField = new JTextField("Hour");
        JTextField minField = new JTextField("Min");
        JButton pushButton = new JButton("Enter");


        undPanel.add(hintLabel,0,0);
        undPanel.add(monthField,0,1);
        undPanel.add(dayField,0,2);
        undPanel.add(yearField,0,3);
        undPanel.add(hourField,0,4);
        undPanel.add(minField,0,5);
        undPanel.add(pushButton,0,6);


        pane.add(undPanel);
        frame.setSize(1400,750);
        frame.setVisible(true);

    }
}
