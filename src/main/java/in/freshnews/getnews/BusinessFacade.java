package in.freshnews.getnews;

import in.freshnews.getnews.model.DataItem;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class BusinessFacade {

    @Autowired
    private InShortsServiceGateway service;

    public List<DataItem> fetchAndProcessNews(String category) {
        log.info("forwarding call to inshortsservicegateway-->");
        Models result = service.getNewsByCategory(category);
        //result.getData().subList(0,2);
        return result.getData().subList(0,2);
    }

    public List<DataItem> fetchAndProcessAllNews(String category) {
        log.info("forwarding call to inshortsservicegateway-->");
        Models result = service.getNewsByCategory(category);
        return result.getData();
    }
}
