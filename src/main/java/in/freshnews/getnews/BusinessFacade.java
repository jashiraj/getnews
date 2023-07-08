package in.freshnews.getnews;

import in.freshnews.getnews.model.DataItem;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


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
/*        List<DataItem> filteredList = unsortedList.stream().filter(item -> item.getAuthor().startsWith("D")).collect(Collectors.toList());*/
       // sortedList = sortResult(filteredList);

        for (DataItem element: unsortedList) {
            long c = Arrays.stream(element.getContent().split("\\s+")).count();
            element.setWordCount(c);
        }

        unsortedList = calculateDuration(unsortedList);
        sortedList = sortResult(unsortedList);
        return sortedList;

    }

    protected List<DataItem> calculateDuration(List<DataItem> unsortedList) {
        for (DataItem element: unsortedList) {
            if (element.getWordCount() > 55) {
                element.setReadDuration("4min");
            } else if (element.getWordCount() > 50) {
                element.setReadDuration("3min");
            } else if (element.getWordCount() > 45) {
                element.setReadDuration("2min");
            } else {
                element.setReadDuration("1min");
            }
        }
        return unsortedList;
    }

    void setService(InShortsServiceGateway mock) {
        this.service = mock;
    }
}
