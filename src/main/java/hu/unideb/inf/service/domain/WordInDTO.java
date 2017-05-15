package hu.unideb.inf.service.domain;

public class WordInDTO {
    private String wordHun;
    private String word;
    private String wordClass;

    public WordInDTO() {
    }

    public String getWordHun() {
        return wordHun;
    }

    public void setWordHun(String wordHun) {
        this.wordHun = wordHun;
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

    @Override
    public String toString() {
        return "WordInDTO{" +
                "wordHun='" + wordHun + '\'' +
                ", word='" + word + '\'' +
                ", wordClass='" + wordClass + '\'' +
                '}';
    }
}
