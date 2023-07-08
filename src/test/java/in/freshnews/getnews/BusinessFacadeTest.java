package in.freshnews.getnews;


import in.freshnews.getnews.model.DataItem;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class BusinessFacadeTest {
//    @Mock
//    private InShortsServiceGateway service;

    BusinessFacade businessFacade = new BusinessFacade();
    @Test
    void testSort() {



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
    @Test
    void testWordCount(){
        Models mockedResponse = new Models();
        DataItem d1 = new DataItem();
        d1.setAuthor("DAA");
        d1.setTitle("BAA");
        d1.setContent("my name is jassi");

        DataItem d2 = new DataItem();
        d2.setAuthor("BAA");
        d2.setTitle("BAA");
        d2.setContent("my name is vishal kumar sahu");

        DataItem d3 = new DataItem();
        d3.setAuthor("AAA");
        d3.setTitle("BAA");
        d3.setContent("dhunnu");

        DataItem d4 = new DataItem();
        d4.setAuthor("BAA");
        d4.setTitle("AAA");
        d4.setContent("my dhunnu");

        List<DataItem> input = new ArrayList<>();
        Collections.addAll(input, d1, d2, d3, d4);
        mockedResponse.setData(input);

        InShortsServiceGateway service = mock(InShortsServiceGateway.class);
        Mockito.when(service.getNewsByCategory(eq("abcd"))).thenReturn(mockedResponse);
        businessFacade.setService(service);

        List<DataItem> output = businessFacade.fetchAndProcessAllNews("abcd");

        assertEquals(1L ,output.get(0).getWordCount());
        assertEquals(2L ,output.get(1).getWordCount());
        assertEquals(6L ,output.get(2).getWordCount());
        assertEquals(4L ,output.get(3).getWordCount());

    }

    @Test
    void testCalculateDuration() {
        DataItem d1 = new DataItem();
        d1.setWordCount(46l);

        DataItem d2 = new DataItem();
        d2.setWordCount(65l);

        DataItem d3 = new DataItem();
        d3.setWordCount(25l);


        DataItem d4 = new DataItem();
        d4.setWordCount(54l);

        List<DataItem> input = new ArrayList<>();

        Collections.addAll(input, d1, d2, d3, d4);

        List<DataItem> output = businessFacade.calculateDuration(input);

        assertEquals("2min" ,output.get(0).getReadDuration());
        assertEquals("4min" ,output.get(1).getReadDuration());
        assertEquals("1min" ,output.get(2).getReadDuration());
        assertEquals("3min" ,output.get(3).getReadDuration());
    }
}
