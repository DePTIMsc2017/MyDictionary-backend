package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.WordEntity;
import hu.unideb.inf.persistence.repositories.WordRepository;
import hu.unideb.inf.service.WordService;
import hu.unideb.inf.service.domain.WordDTO;
import org.modelmapper.ModelMapper;
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
    public List<WordDTO> findMeaning(String name) {
        List<WordEntity> words = wordRepository.findByWord(name);
        List<WordDTO> wordDTO = new ArrayList<>();
        if(words!=null){
            for(WordEntity word : words){
                wordDTO.add(modelMapper.map(word,WordDTO.class));
            }
        }
        return wordDTO;
    }
}
