package in.freshnews.getnews;


import in.freshnews.getnews.BusinessFacade;
import in.freshnews.getnews.model.DataItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessFacadeTest {


    @Test
    void testSort() {

        BusinessFacade businessFacade = new BusinessFacade();

        DataItem d1 = new DataItem();
        d1.setAuthor("DAA");
        d1.setTitle("BAA");

        DataItem d2 = new DataItem();
        d2.setAuthor("BAA");
        d2.setTitle("BAA");

        DataItem d3 = new DataItem();
        d3.setAuthor("AAA");
        d3.setTitle("BAA");

        DataItem d4 = new DataItem();
        d4.setAuthor("BAA");
        d4.setTitle("AAA");

        List<DataItem> input = new ArrayList<>();

        Collections.addAll(input, d1, d2, d3, d4);

        List<DataItem> output = businessFacade.sortResult(input);

        assertEquals("AAA" ,output.get(0).getAuthor(), "The first element must be sorted on Authorname ascending");
        assertEquals("BAA" ,output.get(0).getTitle());
        assertEquals("DAA" ,output.get(3).getAuthor());
        assertEquals("BAA" ,output.get(2).getTitle());
    }
}
