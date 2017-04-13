package hu.unideb.inf.service;

import hu.unideb.inf.service.domain.WordDTO;

import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
public interface WordService {
    List<WordDTO> findMeaning(String name,String sourceLanguage, String destinationLanguage);
}
