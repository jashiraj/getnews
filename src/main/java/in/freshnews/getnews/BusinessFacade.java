package in.freshnews.getnews;

import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import org.springframework.stereotype.Component;

@Component
public class BusinessFacade {
    private InShortsServiceGateway service;
    public Models fetchAndProcessNews(String category) {

        Models result = service.getNewsByCategory(category);
        return result;
    }
}
