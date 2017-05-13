package hu.unideb.inf.modellmappers;

import hu.unideb.inf.persistence.entities.WordEntity;
import hu.unideb.inf.service.domain.LanguageDTO;
import hu.unideb.inf.service.domain.WordDTO;
import hu.unideb.inf.service.domain.WordDTOWithoutMeaning;
import org.modelmapper.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varadi on 2017.04.09..
 */
public class WordMap extends PropertyMap<WordEntity, WordDTO>{
    Converter<WordEntity,LanguageDTO> languageConverter = new AbstractConverter<WordEntity,LanguageDTO>() {
        protected LanguageDTO convert(WordEntity source) {
            if(source!=null){
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map(source.getLanguage(),LanguageDTO.class);
            }
            return null;
        }
    };

    Converter<WordEntity,List<WordDTOWithoutMeaning>> meaningConverter = new AbstractConverter<WordEntity,List<WordDTOWithoutMeaning>>() {
        protected List<WordDTOWithoutMeaning> convert(WordEntity source) {
            if( source != null) {
                ModelMapper modelMapper = new ModelMapper();
                List<WordEntity> meanings = new ArrayList<>(source.getWordMeaning1());
                java.lang.reflect.Type targetListType = new TypeToken<List<WordDTOWithoutMeaning>>() {
                }.getType();
                meanings.addAll(source.getWordMeaning2());
                return  modelMapper.map(meanings,targetListType);
            }
            return null;
        }
    };
    @Override
    protected void configure() {
        map().setId(source.getId());
        using(languageConverter).map(source).setLanguage(null);
        map().setWord(source.getWord());
        map().setWordClass(source.getWordClass());
        using(meaningConverter).map(source).setWordMeaning(null);
    }
}
