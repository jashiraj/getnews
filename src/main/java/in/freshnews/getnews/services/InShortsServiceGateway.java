package in.freshnews.getnews.services;

import in.freshnews.getnews.model.Models;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class InShortsServiceGateway {

    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl
            = "https://inshorts.deta.dev/news?category=";
    public Models getNewsByCategory(String category)
    {
        ResponseEntity<Models> response
                = restTemplate.getForEntity(resourceUrl + category, Models.class);
        return response.getBody();
    }

}
