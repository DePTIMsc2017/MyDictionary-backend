package hu.unideb.inf.web.controllers;

import hu.unideb.inf.security.authentication.JwtTokenUtils;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.domain.UserWithPassDTO;
import hu.unideb.inf.service.exception.UserNotFoundException;
import hu.unideb.inf.service.impl.UserServiceImpl;
import hu.unideb.inf.web.controllers.utils.EncryptionService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mates on 2017. 05. 14..
 */
@RestController
@RequestMapping(value = "/api")
public class RegistrationController {

    @Autowired
    UserService service;

    @Autowired
    private EncryptionService encryptionService;

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

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUser(@RequestParam String username) {
        return ResponseEntity.ok(service.findUserByName(username));
    }

    @RequestMapping(value="/modifyuser",method = RequestMethod.POST)
    public ResponseEntity modify(@RequestBody UserWithPassDTO userWithPassDTO){

        if (!encryptionService.matches(userWithPassDTO.getCurrentPassword(), userWithPassDTO.getPassword())){
            ResponseEntity.badRequest();
        }
        System.out.println(userWithPassDTO);
        service.saveOrUpdate(userWithPassDTO);
        if(userWithPassDTO!=null){
            return ResponseEntity.ok()
                    .header("Access-Control-Expose-Headers", JwtTokenUtils.JWT_TOKEN_HEADER).build();
        } else {
            return ResponseEntity.badRequest().build();
            //TODO: save failed
        }
    }
}
