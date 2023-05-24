package in.freshnews.getnews.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import in.freshnews.getnews.model.Models;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Log4j2
@Service
public class InShortsServiceGateway {

    RestTemplate restTemplate = new RestTemplate();
    @Value("${backend.inshorts.url}")
    private String resourceUrl;
   // String resourceUrl= "https://inshorts.deta.dev/news?category=";
    @HystrixCommand(commandKey = "inshorts", threadPoolKey = "news")
    public Models getNewsByCategory(String category)
    {
        log.info("calling inshorts backend with category- " + category);
        ResponseEntity<Models> response
                = restTemplate.getForEntity(resourceUrl + category, Models.class);
        log.info("HTTP status code recieved"+ response.getStatusCode());
        log.info("response received");
        return response.getBody();
    }

/*    private Models defaultGreeting(String username) {
        Models fallback = new Models();
        fallback.setSuccess(false);
        return fallback;
    }*/
}
