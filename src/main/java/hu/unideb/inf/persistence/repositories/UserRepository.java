package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    UserEntity findById(long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE user SET user_pwd = ?2 WHERE id = ?1",nativeQuery = true)
    void changePassword(long id, String password);

    @Transactional
    void deleteById(long id);
}
