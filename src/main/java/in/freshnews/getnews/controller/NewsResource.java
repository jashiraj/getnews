package in.freshnews.getnews.controller;

import in.freshnews.getnews.BusinessFacade;
import in.freshnews.getnews.model.Models;
import in.freshnews.getnews.services.InShortsServiceGateway;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BusinessFacade bsn;
    @GetMapping(value = "/getTopHeadline")
    public ResponseEntity getTopHeadline(@RequestParam("category") String category) {
        // call inshortServiceGateway
//        InShortsServiceGateway service = new InShortsServiceGateway();
        log.info(" >> incoming call for getTopHeadline in category -> {}", category);
        log.info("forwarding call to businessfacade --->");
        Models result = bsn.fetchAndProcessNews(category);
        // filter 1st news
        log.info("sending response to user: "+ result.getData());
        return new ResponseEntity(result.getData(), HttpStatus.OK);
    }
}
