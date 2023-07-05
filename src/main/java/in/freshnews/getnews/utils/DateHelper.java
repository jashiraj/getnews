package in.freshnews.getnews.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date stringToDate(String strDate){

        String[] strArray = strDate.split(",");
        Date convertedDate = null;
        try {
            convertedDate = new SimpleDateFormat("dd MMM yyyy").parse(strArray[0]);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
        return convertedDate;
    }
    public static String dateToString(Date date){

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, EEEE");
        String strDate = formatter.format(date);
        return strDate;

    }
}
