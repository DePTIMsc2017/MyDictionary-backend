package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.WordGroupCategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by tothd on 2017. 05. 23..
 */
public interface WordGroupCategoryRepository extends CrudRepository<WordGroupCategoryEntity, Long> {

    @Query(value = "select w.* from word_group_category w  where w.category = ?1 ",nativeQuery = true)
    WordGroupCategoryEntity findCategoryByName(String name);
}
