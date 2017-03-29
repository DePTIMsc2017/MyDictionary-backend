package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.03.26..
 */
import hu.unideb.inf.persistence.entities.keys.SearchedWordKey;

import javax.persistence.*;
@Entity
@Table(name="searched_word", schema="mydictionary")
@IdClass(SearchedWordKey.class)
public class SearchedWordEntity implements java.io.Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name="word_id")
    private WordEntity word;

    @Column(name = "count", nullable = false)
    private Integer count;

    public SearchedWordEntity(UserEntity user, WordEntity word, Integer count) {
        this.user = user;
        this.word = word;
        this.count = count;
    }

    public SearchedWordEntity() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public WordEntity getWord() {
        return word;
    }

    public void setWord(WordEntity word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchedWordEntity that = (SearchedWordEntity) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return word != null ? word.equals(that.word) : that.word == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        return result;
    }
}
