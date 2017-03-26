package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
public interface WordRepository extends Repository<WordEntity, Long> {
    List<WordEntity> findByWord(String name);
}
