
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SurajK
 */
public class DateTest {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -50);
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//        System.out.println("Date "+c.getTime());
//        System.out.println("Formatted Date "+format1.format(c.getTime()));
//        try{
//            System.out.println("----- "+format1.parse(format1.format(c.getTime())));
//        }catch(Exception e){
//            System.out.println("-0--"+e);
//        }
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
Date date = sdf.parse("2014-02-15 05:18:08");
            System.out.println("Date obj " +date);
        } catch (Exception e) {
            System.out.println("-0--" + e);
        }
        
//        System.out.println("Date utility "+DateTest.addDays(DateTest.getCurrentDate(),-50));
        


        
    }
    
        public static  Timestamp addDays(Timestamp timestamp, int intDays) {
        Calendar c1 = GregorianCalendar.getInstance();
//        System.out.println(timestamp.toString());
//        System.out.println(timestamp.getYear());
        c1.set(Integer.parseInt(timestamp.toString().substring(0, 4)), timestamp.getMonth(), timestamp.getDate()); // 1999 jan 20
        c1.add(Calendar.DATE, intDays);
        java.util.Date date = c1.getTime();
        return new java.sql.Timestamp(date.getTime());
    }
        
     public static Timestamp getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
    
}
