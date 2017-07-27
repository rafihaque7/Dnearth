import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.math.*;
import java.nio.Buffer;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by rafihaque on 6/24/17.
 */
public class Peach extends JPanel {

    private BufferedImage dayImg;
    private BufferedImage nightImg;
    private BufferedImage navyImg;
    private BufferedImage curveImg;

    public Peach(){
        try {
            dayImg = ImageIO.read(new File("src/day.jpg"));
            nightImg = ImageIO.read(new File("src/night.jpg"));
            //navyImg = ImageIO.read(new URL("http://api.usno.navy.mil/imagery/earth.png?date=6/17/2012"));
            curveImg  = ImageIO.read(new File("src/origcurve.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void drawPoint(Graphics g, int x, int y)
    {
        g.fillOval(x,y,10,10);
    }

    //J is the day of the year, L is latitude

    //Calculates the declination δ of the sun(All angles measured in degrees)
    public static double declination(double d)
    {
        double M = -3.6 + 0.9856d;
        double v = M + 1.9*(Math.sin(M));
        double λ = v + 102.9;
        return 22.8*Math.sin(λ) + 0.6*Math.pow(Math.sin(λ),3);
    }

    public static double l(double t)
    {
        return -15 * t;
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //this.setBackground(Color.WHITE);
        g.drawImage(dayImg, 0, 0, 1400, 700, this);


        //g.drawImage(curveImg,0,0,1400,700,this);
        g.setColor(Color.black);
        //drawPoint(g,100,100);
        //12 Universal time
        double lf = l(12);

        ArrayList latCord = new ArrayList();
        ArrayList longCord = new ArrayList();


        //Arraylist of B

        for (int ψ = 0; ψ <= 360; ψ++) {
            double x = (-1 * Math.cos(lf)) * Math.sin(declination(206)) * Math.sin(ψ) - Math.sin(lf) * Math.cos(ψ);
            double y = (-1 * Math.sin(l(12)) * Math.sin(declination(206)) * Math.sin(ψ) + Math.cos(l(12)) * Math.cos(ψ));
            //drawPoint(g,(int)Math.asin(Math.cos(declination(206))*Math.sin(ψ)),(int)Math.atan2(y,x));
            latCord.add(Math.asin(Math.cos(declination(206)) * Math.sin(ψ)));
            longCord.add(Math.atan2(y, x));
        }
        //g.drawImage(navyImg,0,0,1400,700,this);

        for (int i = 0; i < latCord.size(); i++)
        {
            //drawPoint(g,(int)latCord.get(i),(int)longCord.get(i));
            System.out.println(latCord.get(i));
        }


        //drawPoint(g,250,250);

        int dayoftheyear = 5;



    }
}

//    drawPoint(g,(int)(-1*Math.cos(l(12))*Math.sin(declination(206))*Math.sin(i)-Math.sin(l(12))*Math.cos(i)),(int)(-1*Math.sin(l(12))*Math.sin(declination(206))*Math.sin(i)+Math.cos(l(12))*Math.cos(i)));
