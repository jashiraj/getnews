package in.freshnews.getnews;

import in.freshnews.getnews.model.DataItem;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
@Log4j2
public class BusinessFacade {
    List<DataItem> unsortedList;
    List<DataItem> sortedList;
    @Autowired
    private InShortsServiceGateway service;

    public List<DataItem> fetchAndProcessNews(String category) {
        log.info("forwarding call to inshortsservicegateway-->");
        Models result = service.getNewsByCategory(category);


        if (result.getData().size() > 2) {
            unsortedList =  result.getData().subList(0, 2);
            sortedList = sortResult(unsortedList);
            return sortedList;
        }
        unsortedList = result.getData();
        sortedList = sortResult(unsortedList);
        return sortedList;
    }

    private List<DataItem> sortResult(List<DataItem> unsorted) {
        Comparator<DataItem> compareByAuthorName = Comparator.comparing(DataItem::getAuthor).thenComparing(DataItem::getTitle);
        Collections.sort(unsorted, compareByAuthorName);
        // now its sorted
        return unsorted;
    }

    public List<DataItem> fetchAndProcessAllNews(String category) {
        log.info("forwarding call to inshortsservicegateway-->");
        Models result = service.getNewsByCategory(category);
        unsortedList = result.getData();
        sortedList = sortResult(unsortedList);
        return sortedList;
    }


}
