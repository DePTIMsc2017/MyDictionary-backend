package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.UserEntity;
<<<<<<< HEAD
import org.springframework.data.repository.CrudRepository;
=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
>>>>>>> 33de7964e68cd53758536bbbf297cec4caf1f6ec
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);

    List<UserEntity> findAll();

    UserEntity findById(long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE user SET user_pwd = ?2 WHERE id = ?1",nativeQuery = true)
    void changePassword(long id, String password);

    @Transactional
    void deleteById(long id);
}
