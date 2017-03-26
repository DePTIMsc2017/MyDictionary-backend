package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by mates on 2017. 03. 22..
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public UserDTO getUser(){
        return userService.findUserByName("test");
    }
}
