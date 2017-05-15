package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.WordService;
import hu.unideb.inf.service.domain.WordInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class WordController {

    @Autowired
    WordService wordService;

    @PostMapping("/addword")
    public ResponseEntity<String> addWord(@Valid @RequestBody List<WordInDTO> wordInDTO) {
        wordService.addWord(wordInDTO);

        return ResponseEntity.ok("Success");
    }
}
