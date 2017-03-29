package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.WordService;
import hu.unideb.inf.service.domain.WordDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
@RestController
public class SearchController {

    @Resource
    WordService wordService;

    @RequestMapping(value="/search",method = RequestMethod.GET)
    public List<WordDTO> searchForThisWord(@RequestParam(value = "word") String word){
        return wordService.findMeaning(word);
    }
}
