import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.math.*;

/**
 * Created by rafihaque on 6/24/17.
 */
public class Peach extends JPanel {

    private BufferedImage dayImg;
    private BufferedImage nightImg;
    private BufferedImage navyImg;

    public Peach(){
        try {
            dayImg = ImageIO.read(new File("src/day.jpg"));
            nightImg = ImageIO.read(new File("src/night.jpg"));
            //navyImg = ImageIO.read(new URL("http://api.usno.navy.mil/imagery/earth.png?date=6/17/2012"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void drawPoint(Graphics g, int x, int y)
    {
        g.fillOval(x,y,10,10);
    }

    //J is the day of the year, L is latitude
    static double getY(int J, int L)
    {
        double P =  Math.asin(.39795*Math.cos(.2163108 + 2*Math.atan(.9671396*Math.tan(.00860*(J-186)))));
        return 24 - (24/Math.PI)*Math.acos( (Math.sin(0.8333*Math.PI/180) + Math.sin(L*Math.PI/180)*Math.sin(P)) / (Math.cos(L*Math.PI/180)*Math.cos(P)) );
    }

    static double pixeltoLat(double pix)
    {
        return pix/7.777777777778 - 90;
    }

    static double longtoPix(double longt)
    {
        return (longt+180)*1.944444444444444;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //this.setBackground(Color.WHITE);
        //g.drawImage(dayImg,0,0,1400,700,this);

        //g.drawImage(navyImg,0,0,1400,700,this);
        g.setColor(Color.BLACK);

        //g.drawLine(0,0,200,200);
        //g.setColor(Color.black);
        //g.fillRect(100,100,300,300);
        //g.drawOval(250,250,30,30);

        //drawPoint(g,250,250);

        int dayoftheyear = 5;
        for(int lat=-0; lat<1400; lat++)
        {
            drawPoint(g,lat,(int)longtoPix((int)getY(dayoftheyear,(int)pixeltoLat(lat))));
        }


    }
}
