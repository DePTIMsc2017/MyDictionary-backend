package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.03.25..
 */
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="word", schema="mydictionary")
public class WordEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "word", nullable = false, length = 255)
    private String word;

    @Column(name = "word_class", nullable = false, length = 255)
    private String wordClass;

    @ManyToOne
    @JoinColumn(name = "language", nullable = false)
    private LanguageEntity language;

    @OneToMany(mappedBy="word")
    private List<SearchedWordEntity> searchedWords;
    @ManyToMany
    @JoinTable(
            name="word_meaning",
            joinColumns=@JoinColumn(name="word_1", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="word_2", referencedColumnName="id"))
    private List<WordEntity> wordMeaning1;

    @ManyToMany
    @JoinTable(
            name="word_meaning",
            joinColumns=@JoinColumn(name="word_2", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="word_1", referencedColumnName="id"))
    private List<WordEntity> wordMeaning2;

    @ManyToMany
    @JoinTable(
            name="word_in_word_group",
            joinColumns=@JoinColumn(name="word", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="word_group", referencedColumnName="id"))
    private List<WordGroupEntity> word_groups;
    public WordEntity() {
    }

    public WordEntity(long id, String word, String wordClass, LanguageEntity language, List<WordEntity> wordMeaning1, List<WordEntity> wordMeaning2, List<WordGroupEntity> word_groups) {
        this.id = id;
        this.word = word;
        this.wordClass = wordClass;
        this.language = language;
        this.wordMeaning1 = wordMeaning1;
        this.wordMeaning2 = wordMeaning2;
        this.word_groups = word_groups;
    }


    public List<WordGroupEntity> getWord_groups() {
        return word_groups;
    }

    public void setWord_groups(List<WordGroupEntity> word_groups) {
        this.word_groups = word_groups;
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

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public List<WordEntity> getWordMeaning1() {
        return wordMeaning1;
    }

    public void setWordMeaning1(List<WordEntity> wordMeaning1) {
        this.wordMeaning1 = wordMeaning1;
    }

    public List<WordEntity> getWordMeaning2() {
        return wordMeaning2;
    }

    public void setWordMeaning2(List<WordEntity> wordMeaning2) {
        this.wordMeaning2 = wordMeaning2;
    }

    public List<SearchedWordEntity> getSearchedWords() {
        return searchedWords;
    }

    public void setSearchedWords(List<SearchedWordEntity> searchedWords) {
        this.searchedWords = searchedWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordEntity that = (WordEntity) o;

        if (id != that.id) return false;
        if (!word.equals(that.word)) return false;
        if (!wordClass.equals(that.wordClass)) return false;
        return language.equals(that.language);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + word.hashCode();
        result = 31 * result + wordClass.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WordEntity{" +
                "word='" + word + '\'' +
                ", wordClass='" + wordClass + '\'' +
                ", language=" + language +
                '}';
    }
}
