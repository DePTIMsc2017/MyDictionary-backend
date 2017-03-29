package hu.unideb.inf.persistence.entities.keys;

import hu.unideb.inf.persistence.entities.UserEntity;
import hu.unideb.inf.persistence.entities.WordEntity;

import java.io.Serializable;

/**
 * Created by varadi on 2017.03.26..
 */
public class SearchedWordKey implements Serializable {
    private UserEntity user;
    private WordEntity word;

    public SearchedWordKey() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchedWordKey that = (SearchedWordKey) o;

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
