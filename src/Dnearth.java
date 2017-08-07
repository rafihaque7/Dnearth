import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by rafihaque on 6/23/17.
 */

public class Dnearth {

    //For accessing these variables from other classes such as Peach
    public static boolean manWidthtable = false;    //If the user presses enter, then it changes to true

    static JTextField monthField;
    static JTextField dayField;
    static JTextField yearField;


    static JTextField hourField;
    static JTextField minField;

    public static void main(String[] args) throws IOException
    {
        //Sets the frame and container
        JFrame frame = new JFrame("Day and Night Earth");   //Sets the frame title, which is up top
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //It exits if you close it
        Container pane = frame.getContentPane();    //Sets the content of the frame
        pane.setLayout(new BorderLayout());    //The top will be the map, and underneath will be buttons


        //The paint component part is added
        Peach p = new Peach();
        p.setPreferredSize(new Dimension(1400,700));
        pane.add(p,BorderLayout.PAGE_START);    //Up top

        //New panel to store the under stuff, such as month text field
        JPanel undPanel = new JPanel();
        undPanel.setLayout(new GridLayout(1,7));

        JLabel hintLabel = new JLabel("Type in the Time: ");

        monthField = new JTextField("Month");
        dayField = new JTextField("Day");
        yearField = new JTextField("Year");


        hourField = new JTextField("Hour");
        minField = new JTextField("Min");
        JButton pushButton = new JButton("Enter");


        //Adds everything to the action listener
        Dostuff listener = new Dostuff(monthField,dayField,yearField,hourField,minField);
        pushButton.addActionListener(listener);

        //Adds it to the lower panel
        undPanel.add(hintLabel,0,0);
        undPanel.add(monthField,0,1);
        undPanel.add(dayField,0,2);
        undPanel.add(yearField,0,3);
        undPanel.add(hourField,0,4);
        undPanel.add(minField,0,5);
        undPanel.add(pushButton,0,6);

        //Adds the panel to the container
        pane.add(undPanel);
        frame.setSize(1400,750);
        frame.setVisible(true);

    }

}

class Dostuff implements ActionListener
{
    //Some of the variables are taken as Dostuff parameters eventhough they are not needed
    private JTextField monthField, dayField, yearField, hourField,minField;
    private Container pane;

    Dostuff(JTextField monthField, JTextField dayField, JTextField yearField, JTextField hourField, JTextField minField)
    {
        this.monthField = monthField;
        this.dayField = dayField;
        this.yearField = yearField;
        this.hourField = hourField;
        this.minField = minField;

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Enter"))
        {
            //System.out.println(monthField.getText());

            Dnearth.manWidthtable = true;   //When the user presses enter
            System.out.println("Reloading in 5 seconds!");
        }
    }
}