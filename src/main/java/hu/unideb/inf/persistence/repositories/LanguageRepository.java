package hu.unideb.inf.persistence.repositories;

import hu.unideb.inf.persistence.entities.LanguageEntity;
import org.springframework.data.repository.Repository;

public interface LanguageRepository extends Repository<LanguageEntity, Long> {

    LanguageEntity findByName(String name);

}
