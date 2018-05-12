package helper;

import model.Log;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeHelper {
    public static Date getCurrentTime()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String time = format.format(new java.util.Date()).concat("-0100:00:00");
        Date timePara  = null;
        try {
            timePara = new java.sql.Date(format.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timePara;
    }
}
