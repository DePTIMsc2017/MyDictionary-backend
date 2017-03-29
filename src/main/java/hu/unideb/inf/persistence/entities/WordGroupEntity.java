package hu.unideb.inf.persistence.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Created by varadi on 2017.03.25..
 */

@Entity
@Table(name="word_group", schema="mydictionary")
public class WordGroupEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private WordGroupCategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    private UserEntity creator;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;

    @ManyToOne
    @JoinColumn(name = "basic_language", nullable = false)
    private LanguageEntity basicLanguage;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @ManyToMany
    @JoinTable(
            name="word_in_word_group",
            joinColumns=@JoinColumn(name="word_group", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="word", referencedColumnName="id"))
    private List<WordEntity> words;

    @ManyToMany
    @JoinTable(
            name="shared_word_group",
            joinColumns=@JoinColumn(name="word_group_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
    private List<UserEntity> users;

    public WordGroupEntity() {
    }

    public WordGroupEntity(long id, String name, WordGroupCategoryEntity category, UserEntity creator, Date creationTime, LanguageEntity basicLanguage, Boolean isPublic) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.creator = creator;
        this.creationTime = creationTime;
        this.basicLanguage = basicLanguage;
        this.isPublic = isPublic;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<WordEntity> getWords() {
        return words;
    }

    public void setWords(List<WordEntity> words) {
        this.words = words;
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

    public WordGroupCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(WordGroupCategoryEntity category) {
        this.category = category;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public LanguageEntity getBasicLanguage() {
        return basicLanguage;
    }

    public void setBasicLanguage(LanguageEntity basicLanguage) {
        this.basicLanguage = basicLanguage;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordGroupEntity that = (WordGroupEntity) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        if (!category.equals(that.category)) return false;
        if (!creator.equals(that.creator)) return false;
        if (!creationTime.equals(that.creationTime)) return false;
        if (!basicLanguage.equals(that.basicLanguage)) return false;
        return isPublic.equals(that.isPublic);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + creator.hashCode();
        result = 31 * result + creationTime.hashCode();
        result = 31 * result + basicLanguage.hashCode();
        result = 31 * result + isPublic.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WordGroupEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
