package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.WordEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
public interface WordRepository extends CrudRepository<WordEntity, Long> {
    List<WordEntity> findByWord(String name);

    @Query(value = "select w.* from word w join language l on w.language = l.id where w.word = ?1 AND l.name = ?2",nativeQuery = true)
    List<WordEntity> findByWordAndLanguages(String word, String language);

    @Query(value = "select w.* from word w join language l on w.language = l.id join word_meaning wm on (wm.word_1=w.id or wm.word_2=w.id) where (wm.word_1=?1 OR wm.word_2=?1) AND l.name = ?2",nativeQuery = true)
    List<WordEntity> findMeanings(long id, String language);

    @Query(value = "select w.* from word w join word_meaning wm on (wm.word_1=w.id or wm.word_2=w.id) where (wm.word_1=?1 OR wm.word_2=?1) AND w.language != ?2", nativeQuery = true)
    List<WordEntity> findMeaningsNotEqualLang(long id, long id1);
}
