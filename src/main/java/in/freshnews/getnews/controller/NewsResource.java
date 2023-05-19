package in.freshnews.getnews.controller;

import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsapi")
@Log4j2
public class NewsResource {
    @GetMapping(value = "/getTopHeadline")
    public ResponseEntity getTopHeadline(@RequestParam("category") String category) {
        // call inshortServiceGateway
        InShortsServiceGateway service = new InShortsServiceGateway();
        Models result = service.getNewsByCategory(category);
        // filter 1st news
        return new ResponseEntity(result.getData().get(0).getTitle(), HttpStatus.OK);
    }
}
