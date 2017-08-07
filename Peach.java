import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;


/**
 * Created by rafihaque on 6/24/17.
 */
public class Peach extends JPanel implements ActionListener{

    private BufferedImage dayImg;
    private BufferedImage nightImg;

    public Peach(){
        //Loads the images
        try {
            dayImg = ImageIO.read(new File("day.jpg"));
            nightImg = ImageIO.read(new File("night.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //This for drawing a circle
    public static void drawPoint(Graphics g, int x, int y)
    {
        g.fillOval(x,y,1,2);
    }

    //It repaints every 10 seconds
    Timer tm = new Timer(10000,this);
    //int x = 500, velX = 100; This is for testing purposes
    //int cusMin = 0;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(dayImg, 0, 0, 1400, 700, this);
        g.setColor(Color.black);

        Curve filter_ = new Curve(1400, 700, 0);
        if(!Dnearth.manWidthtable) filter_.updateWidthTable();
        else if(Dnearth.manWidthtable)
        {
            filter_.updateWidthTable(Integer.parseInt(Dnearth.monthField.getText()),Integer.parseInt(Dnearth.dayField.getText()),Integer.parseInt(Dnearth.yearField.getText()),Integer.parseInt(Dnearth.hourField.getText()),Integer.parseInt(Dnearth.minField.getText()));
            //filter_.updateWidthTable(8,6,2017,0,cusMin);
        }

        for (int i = 0; i < filter_.wtab_.length; i++) {
            for (int j = filter_.wtab_[i]; j < 1400; j++) {
                drawPoint(g, i, j);
            }
        }
        tm.start();
        //g.fillOval(x,500,200,200); To make sure it works
    }


    public void actionPerformed(ActionEvent e)
    {
        //x = x + velX;
        //System.out.println(Dnearth.manWidthtable);
        //cusMin = cusMin + 30;
        repaint();
    }
}
