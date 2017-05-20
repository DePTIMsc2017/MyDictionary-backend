package hu.unideb.inf.web.controllers;

import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.domain.GrantedAuthorityImpl;
import hu.unideb.inf.service.exception.UserNotFoundException;
import hu.unideb.inf.web.controllers.utils.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EncryptionService encryptionService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }


    @PostMapping(value = "/changePassword", params = { "id", "newPassword", "oldPassword"})
    public ResponseEntity changePassword(@RequestParam(value = "id") long id,@RequestParam(value="newPassword") String newPassword,@RequestParam(value="oldPassword") String oldPassword){
        //if(!authenticatedUser.getAuthorities().contains(new GrantedAuthorityImpl("ADMIN"))){ //TODO: nincs admin jogosultság
            //if(authenticatedUser.getId()==id){   // TODO: saját magának a jelszavát akarja módosítani.
                try{
                    UserDTO user = userService.findUserByID(id);
                    if(!encryptionService.matches(oldPassword, user.getPassword())){
                        throw new IllegalArgumentException("Password doesn\'t match.");
                    }
                } catch (UserNotFoundException e){
                    throw new IllegalArgumentException("User not found");
                }
            /*} else{
                throw new IllegalArgumentException("Can't modify the password of this user.");
            }*/
        //}
        String encriptedPassword = encryptionService.encode(newPassword);
        userService.changePassword(id,encriptedPassword);
        return ResponseEntity.ok(true);
    }

    @PostMapping(value = "/changePassword", params = { "id", "newPassword" })
    public ResponseEntity changePasswordWithoutPassword(@RequestParam(value = "id") long id,@RequestParam(value="newPassword") String newPassword){
        return changePassword(id,newPassword,"");
    }

    @PostMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam(value = "id") long id){
        /*if(!authenticatedUser.getAuthorities().contains(new GrantedAuthorityImpl("ADMIN"){ //TODO: nincs admin jogosultság
            throw new IllegalArgumentException("Required authorities are missing.");
        }*/
        try {
            UserDTO userDTO = userService.findUserByID(id);
            if (userDTO.getAuthorities().contains(new GrantedAuthorityImpl("ADMIN"))) {
                throw new IllegalArgumentException("User isn\'t deleteable.");
            }
            userService.deleteUser(id);
            return ResponseEntity.ok(true);
        } catch (UserNotFoundException e){
            throw new IllegalArgumentException("User not found");
        }
    }
}
