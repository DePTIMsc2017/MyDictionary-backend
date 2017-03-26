package hu.unideb.inf.service.domain;

import java.io.Serializable;

/**
 * Created by varadi on 2017.03.26..
 */
public class SearchedWordDTO implements Serializable {
    private UserDTO user;
    private WordDTO word;
    private Integer count;

    public SearchedWordDTO() {
    }

    public SearchedWordDTO(UserDTO user, WordDTO word, Integer count) {
        this.user = user;
        this.word = word;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchedWordDTO that = (SearchedWordDTO) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return word != null ? word.equals(that.word) : that.word == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        return result;
    }

    public UserDTO getUser() {

        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public WordDTO getWord() {
        return word;
    }

    public void setWord(WordDTO word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
