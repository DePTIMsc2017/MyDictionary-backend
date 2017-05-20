package hu.unideb.inf.service.impl;

import hu.unideb.inf.modellmappers.WordMap;
import hu.unideb.inf.persistence.entities.LanguageEntity;
import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.entities.WordEntity;
import hu.unideb.inf.persistence.repositories.LanguageRepository;
import hu.unideb.inf.persistence.repositories.WordRepository;
import hu.unideb.inf.service.WordService;
import hu.unideb.inf.service.domain.WordDTO;
import hu.unideb.inf.service.domain.WordDTOWithoutMeaning;
import hu.unideb.inf.service.domain.WordInDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
@Service
public class WordServiceImpl implements WordService{
    @Autowired
    WordRepository wordRepository;

    @Autowired
    LanguageRepository languageRepository;

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

    @Override
    @Transactional(readOnly = true)
    public List<WordDTO> findByMeaning(String word) {
        List<WordEntity> words = wordRepository.findByWord(word);
        java.lang.reflect.Type targetListType = new TypeToken<List<WordDTO>>() {}.getType();
        List<WordDTO> wordDTOS = modelMapper.map(words,targetListType);
        final java.lang.reflect.Type targetListType1 = new TypeToken<List<WordDTOWithoutMeaning>>() {}.getType();

        wordDTOS.forEach(item ->
            item.setWordMeaning(modelMapper.map(wordRepository.findMeaningsNotEqualLang(item.getId(),
                    item.getLanguage().getId()), targetListType1))
        );

        return wordDTOS;
    }

    @Override
    @Transactional
    public boolean addWord(List<WordInDTO> wordInDTO) {
        wordInDTO.stream().forEach(item -> this.addWord(item));

        return true;
    }

    private void addWord(WordInDTO wordInDTO) {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setWordClass(wordInDTO.getWordClass().toLowerCase());
        wordEntity.setWord(wordInDTO.getWordHun().toLowerCase());
        wordEntity.setLanguage(languageRepository.findByName("hu"));

        wordRepository.save(wordEntity);

        WordEntity wordEntity1 = new WordEntity();
        wordEntity1.setWordClass(wordInDTO.getWordClass().toLowerCase());
        wordEntity1.setWord(wordInDTO.getWord().toLowerCase());
        wordEntity1.setLanguage(languageRepository.findByName("en"));

        wordEntity1.setWordMeaning1(wordRepository.findByWord(wordInDTO.getWordHun()));

        wordRepository.save(wordEntity1);
    }
}
