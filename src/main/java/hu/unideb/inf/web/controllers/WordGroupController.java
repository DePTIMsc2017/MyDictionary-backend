package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.WordGroupService;
import hu.unideb.inf.service.domain.CreateGroupDTO;
import hu.unideb.inf.service.domain.WordGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
@RestController
@RequestMapping(value = "/api")
public class WordGroupController {


    @Autowired
    WordGroupService wordGroupService;

    @GetMapping("/wordgroupbyuser")
    public ResponseEntity<List<WordGroupDTO>> getWordGroupsByUsername(@RequestParam String username) {

        return ResponseEntity.ok(wordGroupService.findCollectionsByUsername(username));

    }

    @GetMapping("/wordlistbycollection")
    public ResponseEntity<List<WordGroupDTO>> getWordListByWordGroupId(@RequestParam int id) {

        return ResponseEntity.ok(wordGroupService.findWordListByWordGroupId(id));

    }

    @PostMapping("/creategroup")
    public ResponseEntity<String> createGroup(@RequestBody CreateGroupDTO createGroupDTO){

        wordGroupService.createGroup(createGroupDTO);

        return ResponseEntity.ok("Succes");
    }

}
