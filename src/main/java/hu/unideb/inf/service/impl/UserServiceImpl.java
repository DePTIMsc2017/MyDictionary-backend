package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.repositories.UserRepository;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        UserEntity user = userRepository.save(modelMapper.map(userDTO, UserEntity.class));
        return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
    }

    @Override
    @Transactional
    public List<UserDTO> findAll() {
        List<UserEntity> entities = userRepository.findAll();
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        for (UserEntity entity:entities) {
            dtos.add(modelMapper.map(entity, UserDTO.class));
        }
        return dtos;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(s);
        return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
    }
}
