/**
 * Created by rafihaque on 8/4/17.
 */

import java.util.Calendar;  //To be able to use cal.get, Current time, year, date, etc.

class Curve
{
    int width_,height_,offset_;
    int [] wtab_;
    int sign_;

    private static short monthOffset_[] = {
            0, 31, 59, 90, 120, 151, 181, 212, 243, 273,
            304, 334
    };

    Curve(int width, int height, int offset)
    {
        width_ = width;
        height_ = height;
        offset_ = offset;
        wtab_ = new int[width];
        sign_ = 1;
    }

    /*
        updateWidthTable Changes wtab_, which essentially stores y coordinate
     */

    //This calculates based on current time
    void updateWidthTable(Calendar cal)
    {

        double d = (6.2831853071795862D * (double)((cal.get(Calendar.DAY_OF_MONTH) + monthOffset_[cal.get(Calendar.MONTH)]) - 80)) / 365D;

        if(d == 0.0D) d = 0.001D;

        double d1 = 1.0D / (Math.sin(d) * Math.tan(0.40927970959267024D));

        d = (6.2831799999999998D * (double)(cal.get(Calendar.HOUR_OF_DAY) * 60 + offset_ + cal.get(Calendar.MINUTE) - (cal.get(Calendar.DST_OFFSET) + cal.get(Calendar.ZONE_OFFSET))/60000)) / 1440D;

        sign_ = d1 < 0.0D ? -1 : 1;

        for(int i = 0; i < wtab_.length; i++)
        {
            wtab_[i] = (int)((double)(height_ / 2) + (Math.atan(d1 * Math.cos(d + ((double)(2 * i) * 3.1415926535897931D) / (double)width_)) * (double)height_) / 3.1415926535897931D);
        }
        System.out.println(cal.getTime().toString() + ": Width Table Updated");
    }//updateWidthTable

    //Current time, but does not require any parameter
    void updateWidthTable()
    {
        updateWidthTable(Calendar.getInstance());
    }

    //Based on the time that the user inputs
    void updateWidthTable(int month, int day, int year, int hour, int min)
    {
        Calendar cal = Calendar.getInstance();

        double d = (6.2831853071795862D * (double) ((day + monthOffset_[month]) - 80)) / 365D;

        if (d == 0.0D) d = 0.001D;

        double d1 = 1.0D / (Math.sin(d) * Math.tan(0.40927970959267024D));

        d = (6.2831799999999998D * (double) (hour * 60 + offset_ + min - (cal.get(Calendar.DST_OFFSET) + cal.get(Calendar.ZONE_OFFSET)) / 60000)) / 1440D;

        sign_ = d1 < 0.0D ? -1 : 1;

        for (int i = 0; i < wtab_.length; i++)
        {
            wtab_[i] = (int) ((double) (height_ / 2) + (Math.atan(d1 * Math.cos(d + ((double) (2 * i) * 3.1415926535897931D) / (double) width_)) * (double) height_) / 3.1415926535897931D);
        }
    }
}