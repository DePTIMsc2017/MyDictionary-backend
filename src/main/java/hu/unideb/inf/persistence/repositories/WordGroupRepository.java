package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.WordGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
public interface WordGroupRepository extends CrudRepository<WordGroupEntity, Long> {

    @Query(value = "select w.* from word_group w join user u on w.creator = u.id where u.user_name = ?1 ",nativeQuery = true)
    List<WordGroupEntity> getWordGroupByUserName(String username);


}
