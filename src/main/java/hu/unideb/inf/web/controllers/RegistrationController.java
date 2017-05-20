package hu.unideb.inf.web.controllers;

import hu.unideb.inf.security.authentication.JwtTokenUtils;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mates on 2017. 05. 14..
 */
@RestController
@RequestMapping(value = "/api")
public class RegistrationController {

    @Autowired
    UserService service;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        service.save(userDTO);
        if(userDTO!=null){
            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER).build();
        } else {
            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER).build();
            //TODO: save failed
        }

    }

    @RequestMapping(value="/modifyuser",method = RequestMethod.POST)
    public ResponseEntity modify(@RequestBody UserDTO userDTO){
        service.saveOrUpdate(userDTO);
        if(userDTO!=null){
            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER).build();
        } else {
            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER).build();
            //TODO: save failed
        }
    }
}
