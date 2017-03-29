package hu.unideb.inf.service.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
public class WordGroupDTO implements java.io.Serializable {
    private long id;
    private String name;
    private WordGroupCategoryDTO category;
    private UserDTO creator;
    private Date creationTime;
    private LanguageDTO basicLanguage;
    private Boolean isPublic;
    private List<WordDTO> words;
    private List<UserDTO> users;

    public WordGroupDTO(long id, String name, WordGroupCategoryDTO category, UserDTO creator, Date creationTime, LanguageDTO basicLanguage, Boolean isPublic, List<WordDTO> words, List<UserDTO> users) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.creator = creator;
        this.creationTime = creationTime;
        this.basicLanguage = basicLanguage;
        this.isPublic = isPublic;
        this.words = words;
        this.users = users;
    }

    public WordGroupDTO() {
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

    public List<WordDTO> getWords() {
        return words;
    }

    public void setWords(List<WordDTO> words) {
        this.words = words;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordGroupDTO that = (WordGroupDTO) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (creator != null ? !creator.equals(that.creator) : that.creator != null) return false;
        return creationTime != null ? creationTime.equals(that.creationTime) : that.creationTime == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WordGroupDTO{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", creator=" + creator +
                '}';
    }
}
