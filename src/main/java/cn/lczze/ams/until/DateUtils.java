package cn.lczze.ams.until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lczze on 2021/3/21 9:45
 */
public class DateUtils {

    public static void main(String[] args) {
//        getNewToday("lcz");
    }

    public static String getNewToday(String title){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String format = df.format(date);
//        System.out.println(title+format);
        return title+format;
    }

    public static String getNewDate(String title){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String format = df.format(date);
        System.out.println(date);
        return title+format;
    }

}
