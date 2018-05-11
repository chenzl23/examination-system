package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyGenerator {

    public static String createKey(int role)
    {
        int num0=100+(int)(Math.random()*800);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String createdate = sdf.format(date);
        return createdate+String.valueOf(role)+String.valueOf(num0);
    }
}
