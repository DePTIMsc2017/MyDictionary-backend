package hu.unideb.inf.service;

import hu.unideb.inf.service.domain.WordGroupDTO;

import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
public interface WordGroupService {

    List<WordGroupDTO> findCollectionsByUsername(String username);

    List<WordGroupDTO> findWordListByWordGroupId(int id);
}
