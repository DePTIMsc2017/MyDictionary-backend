package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.repositories.UserRepository;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by mates on 2017. 03. 22..
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Resource
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserByName(String username) {
        UserEntity user = userRepository.findByUsername(username);
        return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO login(UserDTO user) throws UserNotFoundException {
        UserDTO userDTO;
        UserEntity userEntity = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        userDTO=modelMapper.map(userEntity,UserDTO.class);
        return userDTO;
    }

    @Override
    @Transactional
    public Long saveOrUpdate(UserDTO userDTO) {
        return null;
    }
}
