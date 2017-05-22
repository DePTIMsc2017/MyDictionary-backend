package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.repositories.UserRepository;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.domain.UserDTO;
import hu.unideb.inf.service.exception.UserAlreadyExistException;
import hu.unideb.inf.service.exception.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public Long saveOrUpdate(UserDTO userDTO) {
        SimpleDateFormat sf= new SimpleDateFormat("YYYY-MM-DD");
        String date = userDTO.getBirthDate();
        userDTO.setBirthDate(null);

        UserEntity user = userRepository.findByUsername(userDTO.getUsername());
        if(user != null) {
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setCountry(userDTO.getCountry());
            user.setCity(userDTO.getCity());
            user.setEmail(userDTO.getEmail());
        }
        //UserEntity toDb = modelMapper.map(userDTO, UserEntity.class);
        //toDb.setId(user.getId());
        //UserEntity user = userRepository.save(modelMapper.map(userDTO, UserEntity.class));
        try {
            if(user!=null) {
                user.setBirthDate(sf.parse(date));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            user=userRepository.save(user);

        }catch (org.springframework.dao.DataAccessException e){
            user=null;
        }

        return (user != null) ? modelMapper.map(user, UserDTO.class).getId() : null;
    }

    @Override
    //@Transactional(noRollbackFor =  javax.persistence.RollbackException.class)
    public UserDTO save(UserDTO userDTO) {

            SimpleDateFormat sf= new SimpleDateFormat("YYYY-MM-DD");
            String date = userDTO.getBirthDate();
            userDTO.setBirthDate(null);
            UserEntity user = modelMapper.map(userDTO, UserEntity.class);
            //UserEntity user = userRepository.save(modelMapper.map(userDTO, UserEntity.class));
            try {
                user.setBirthDate(sf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                user=userRepository.save(user);

            }catch (org.springframework.dao.DataAccessException e){
                user=null;
            }
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
    public UserDTO findUserByID(long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id);
        if(user==null){
            throw new UserNotFoundException();
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void changePassword(long id, String password) {
        userRepository.changePassword(id,password);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(s);
        return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
    }
}
