package hu.unideb.inf.service.impl;

import hu.unideb.inf.modellmappers.WordMap;
import hu.unideb.inf.persistence.entities.WordEntity;
import hu.unideb.inf.persistence.repositories.WordRepository;
import hu.unideb.inf.service.WordService;
import hu.unideb.inf.service.domain.WordDTO;
import hu.unideb.inf.service.domain.WordDTOWithoutMeaning;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
@Service
public class WordServiceImpl implements WordService{
    @Autowired
    WordRepository wordRepository;

    @Resource
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<WordDTO> findMeaning(String name,String sourceLanguage, String destinationLanguage) {
        List<WordEntity> words = wordRepository.findByWordAndLanguages(name,sourceLanguage);
        java.lang.reflect.Type targetListType = new TypeToken<List<WordDTO>>() {}.getType();
        List<WordDTO> wordDTOS = modelMapper.map(words,targetListType);
        targetListType = new TypeToken<List<WordDTOWithoutMeaning>>() {}.getType();
        for (WordDTO wordDTO : wordDTOS){
            List<WordEntity> w =wordRepository.findMeanings(wordDTO.getId(),destinationLanguage);
            wordDTO.setWordMeaning(modelMapper.map(wordRepository.findMeanings(wordDTO.getId(),destinationLanguage),targetListType));
        }
        return wordDTOS;
    }
}
