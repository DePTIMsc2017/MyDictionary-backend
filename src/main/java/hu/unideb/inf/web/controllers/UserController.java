package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}
