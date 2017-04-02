package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();
}
