package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.WordGroupEntity;
import hu.unideb.inf.persistence.repositories.WordGroupRepository;
import hu.unideb.inf.service.WordGroupService;
import hu.unideb.inf.service.domain.WordDTO;
import hu.unideb.inf.service.domain.WordGroupCollectionDTO;
import hu.unideb.inf.service.domain.WordGroupDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
@Service
public class WordGroupServiceImpl implements WordGroupService {

    @Autowired
    WordGroupRepository wordGroupRepository;

    @Resource
    ModelMapper modelMapper;

    @Override
    public List<WordGroupDTO> findCollectionsByUsername(String username) {

        List<WordGroupEntity> wordGroupEntities = wordGroupRepository.getWordGroupByUserName(username);

        java.lang.reflect.Type targetListType = new TypeToken<List<WordGroupCollectionDTO>>() {
        }.getType();
        List<WordGroupDTO> wordGroupDTO = modelMapper.map(wordGroupEntities, targetListType);

        return wordGroupDTO;
    }
}
