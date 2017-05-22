package hu.unideb.inf.service.domain;

import java.util.Date;

/**
 * Created by tothd on 2017. 05. 22..
 */
public class WordGroupCollectionDTO {

    private long id;
    private String name;
    private WordGroupCategoryDTO category;
    private UserDTO creator;
    private Date creationTime;
    private LanguageDTO basicLanguage;
    private Boolean isPublic;

    public WordGroupCollectionDTO(long id, String name, WordGroupCategoryDTO category, UserDTO creator, Date creationTime, LanguageDTO basicLanguage, Boolean isPublic) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.creator = creator;
        this.creationTime = creationTime;
        this.basicLanguage = basicLanguage;
        this.isPublic = isPublic;
    }

    public WordGroupCollectionDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WordGroupCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(WordGroupCategoryDTO category) {
        this.category = category;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public LanguageDTO getBasicLanguage() {
        return basicLanguage;
    }

    public void setBasicLanguage(LanguageDTO basicLanguage) {
        this.basicLanguage = basicLanguage;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }
}
