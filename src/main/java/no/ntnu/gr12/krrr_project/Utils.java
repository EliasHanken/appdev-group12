package no.ntnu.gr12.krrr_project;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date dateNow(){
        return new Date();
    }

    public static Date dateLaterDays(int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE,days);
        return cal.getTime();
    }

    public static Date dateLaterSeconds(int seconds){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND,seconds);
        return cal.getTime();
    }
}
