package hu.unideb.inf.service.domain;

/**
 * Created by varadi on 2017.03.26..
 */
public class WordDTOWithoutMeaning implements java.io.Serializable{
    private long id;
    private String word;
    private String wordClass;
    private LanguageDTO language;

    public WordDTOWithoutMeaning() {
    }

    public WordDTOWithoutMeaning(long id, String word, String wordClass, LanguageDTO language) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordDTOWithoutMeaning that = (WordDTOWithoutMeaning) o;

        if (id != that.id) return false;
        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        if (wordClass != null ? !wordClass.equals(that.wordClass) : that.wordClass != null) return false;
        return language != null ? language.equals(that.language) : that.language == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (wordClass != null ? wordClass.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}

