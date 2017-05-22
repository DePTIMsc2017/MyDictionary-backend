package hu.unideb.inf.service.impl;

import hu.unideb.inf.persistence.entities.LanguageEntity;
import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.entities.WordGroupCategoryEntity;
import hu.unideb.inf.persistence.entities.WordGroupEntity;
import hu.unideb.inf.persistence.repositories.LanguageRepository;
import hu.unideb.inf.persistence.repositories.UserRepository;
import hu.unideb.inf.persistence.repositories.WordGroupCategoryRepository;
import hu.unideb.inf.persistence.repositories.WordGroupRepository;
import hu.unideb.inf.service.UserService;
import hu.unideb.inf.service.WordGroupService;
import hu.unideb.inf.service.domain.CreateGroupDTO;
import hu.unideb.inf.service.domain.WordGroupCollectionDTO;
import hu.unideb.inf.service.domain.WordGroupDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
@Service
public class WordGroupServiceImpl implements WordGroupService {

    @Autowired
    WordGroupRepository wordGroupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    WordGroupCategoryRepository wordGroupCategoryRepository;

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

    @Override
    public List<WordGroupDTO> findWordListByWordGroupId(int id) {

        List<WordGroupEntity> wordGroupEntities = wordGroupRepository.getWordListByWordGroupId(id);

        java.lang.reflect.Type targetListType = new TypeToken<List<WordGroupDTO>>() {
        }.getType();
        List<WordGroupDTO> wordGroupDTOList = modelMapper.map(wordGroupEntities, targetListType);

        return wordGroupDTOList;
    }

    @Override
    public void createGroup(CreateGroupDTO createGroupDTO) {

        UserEntity userEntity = userRepository.findById(createGroupDTO.getId());

        LanguageEntity languageEntity = languageRepository.findByName("hu");

        WordGroupCategoryEntity wordGroupCategoryEntity = wordGroupCategoryRepository.findCategoryByName("fruits");

        WordGroupEntity wordGroupEntity = new WordGroupEntity();
        wordGroupEntity.setCreator(userEntity);
        wordGroupEntity.setBasicLanguage(languageEntity);
        wordGroupEntity.setCategory(wordGroupCategoryEntity);
        wordGroupEntity.setCreationTime(new Date());
        wordGroupEntity.setName(createGroupDTO.getName());
        wordGroupEntity.setPublic(Boolean.TRUE);

        wordGroupRepository.save(wordGroupEntity);


    }
}
