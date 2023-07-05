package in.freshnews.getnews.utils;

import in.freshnews.getnews.model.DataItem;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static in.freshnews.getnews.utils.DateHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateHelperTest {
    @Test
    void testDate() {
        Date exp = new Date(123, 04, 18);
        Date output = stringToDate("18 May 2023, Thursday");
        assertEquals(exp, output);
    }

    @Test
    void testDateJuly() {
        Date exp = new Date(123, 06, 18);
        Date output = stringToDate("18 July 2023, Thursday");
        assertEquals(exp, output);
    }

    @Test
    void tesToString() {
        String exp = "18 July 2023, Tuesday";
        Date date = new Date(123, 06, 18);
        String output = dateToString(date);
        assertEquals(exp, output);
    }
}
