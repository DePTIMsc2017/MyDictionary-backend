package hu.unideb.inf.service;

import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.exception.UserNotFoundException;

/**
 * Created by mates on 2017. 03. 22..
 */
public interface UserService {

    UserDTO findUserByName(String username);
    UserDTO login(UserDTO user) throws UserNotFoundException;
    Long saveOrUpdate(UserDTO userDTO);
}
