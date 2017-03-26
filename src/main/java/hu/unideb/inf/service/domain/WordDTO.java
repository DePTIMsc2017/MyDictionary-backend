package hu.unideb.inf.service.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by varadi on 2017.03.26..
 */
public class WordDTO  implements java.io.Serializable{
    private long id;
    private String word;
    private String wordClass;
    private LanguageDTO language;

    private List<WordDTOWithoutMeaning> wordMeaning1;
    private List<WordDTOWithoutMeaning> wordMeaning2;

    public WordDTO() {
    }

    public WordDTO(long id, String word, String wordClass, LanguageDTO language) {
        this.id = id;
        this.word = word;
        this.wordClass = wordClass;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    public LanguageDTO getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    public List<WordDTOWithoutMeaning> getWordMeaning1() {
        return wordMeaning1;
    }

    public void setWordMeaning1(List<WordDTO> wordMeaningDTO1) {
        wordMeaning1 = new ArrayList<>();
        for(WordDTO word : wordMeaningDTO1){
            wordMeaning1.add(new WordDTOWithoutMeaning(word.id,word.word,word.wordClass,word.language));
        }
    }

    public List<WordDTOWithoutMeaning> getWordMeaning2() {
        return wordMeaning2;
    }

    public void setWordMeaning2(List<WordDTO> wordMeaningDTO2) {
        wordMeaning2 = new ArrayList<>();
        for(WordDTO word : wordMeaningDTO2){
            wordMeaning2.add(new WordDTOWithoutMeaning(word.id,word.word,word.wordClass,word.language));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordDTO wordDTO = (WordDTO) o;

        if (id != wordDTO.id) return false;
        if (word != null ? !word.equals(wordDTO.word) : wordDTO.word != null) return false;
        if (wordClass != null ? !wordClass.equals(wordDTO.wordClass) : wordDTO.wordClass != null) return false;
        if (language != null ? !language.equals(wordDTO.language) : wordDTO.language != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (wordClass != null ? wordClass.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "word='" + word + '\'' +
                ", wordClass='" + wordClass + '\'' +
                ", language=" + language +
                '}';
    }
}
