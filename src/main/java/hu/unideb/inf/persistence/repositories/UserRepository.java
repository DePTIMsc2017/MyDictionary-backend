package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
/**
 * Created by mates on 2017. 03. 22..
 */
public interface UserRepository extends Repository<UserEntity, Long> {

    UserEntity findByUsernameAndPassword(String username, String password);

    UserEntity findByUsername(String username);
}
