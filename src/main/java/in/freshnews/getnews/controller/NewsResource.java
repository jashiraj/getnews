package in.freshnews.getnews.controller;

import in.freshnews.getnews.BusinessFacade;
import in.freshnews.getnews.model.DataItem;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/newsapi")
@Log4j2
public class NewsResource {
    @Autowired
    private BusinessFacade logic;

    @GetMapping(value = "/getTopHeadline")
    public ResponseEntity<List> getTopHeadline(@RequestParam("category") String category) {
        // call inshortServiceGateway
//        InShortsServiceGateway service = new InShortsServiceGateway();
        log.info(" >> incoming call for getTopHeadline in category -> {}", category);
        if(category == null || category.isEmpty()) {
            log.error("no category found");
            return new ResponseEntity("please select a categorsy", HttpStatus.BAD_REQUEST);
        }
                log.info("forwarding call to businessfacade --->");
                List<DataItem> listOfDataItem = logic.fetchAndProcessNews(category);
                // filter 1st news
                log.info("sending response to user: " + listOfDataItem);
                return new ResponseEntity<List>(listOfDataItem, HttpStatus.OK);
            }
    @GetMapping(value = "/getAllNewsItems")
    public ResponseEntity<List<DataItem>> getAllHeadline(@RequestParam("category") String category) {
        // call inshortServiceGateway
//        InShortsServiceGateway service = new InShortsServiceGateway();
        log.info(" >> incoming call for getTopHeadline in category -> {}", category);
        if(category == null || category.isEmpty()) {
            log.error("no category found");
            return new ResponseEntity("please select a category", HttpStatus.BAD_REQUEST);
        }
        log.info("forwarding call to businessLogic --->");
        List<DataItem> listOfDataItem = logic.fetchAndProcessAllNews(category);
        // filter 1st news
        log.info("sending response to user: " + listOfDataItem);
        return new ResponseEntity(listOfDataItem, HttpStatus.OK);
    }
}
