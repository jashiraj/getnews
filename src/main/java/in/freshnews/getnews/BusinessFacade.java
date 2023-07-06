package in.freshnews.getnews;

import in.freshnews.getnews.model.DataItem;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static in.freshnews.getnews.utils.DateHelper.stringToDate;

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

    protected List<DataItem> sortResult(List<DataItem> unsorted){
        Comparator<DataItem> compareByAuthorName = Comparator.comparing(DataItem::getAuthor).thenComparing(DataItem::getTitle);
      //Date date = stringToDate(unsorted.get(0).getDate());
        Collections.sort(unsorted, compareByAuthorName);
        // now its sorted
        return unsorted;
    }

    public List<DataItem> fetchAndProcessAllNews(String category) {
        log.info("forwarding call to inshortsservicegateway-->");
        Models result = service.getNewsByCategory(category);
        // ToDO: Filter out every news item, where Author name does not start with "A"
        unsortedList = result.getData();
        List<DataItem> filteredList = unsortedList.stream()
                .filter(item -> item.getAuthor()
                        .startsWith("D"))
                .collect(Collectors.toList());
        sortedList = sortResult(filteredList);
        //sortedList = sortResult(unsortedList);
        return sortedList;

    }


}
