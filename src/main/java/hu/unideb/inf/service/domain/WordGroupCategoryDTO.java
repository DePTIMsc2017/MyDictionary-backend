package hu.unideb.inf.service.domain;

/**
 * Created by varadi on 2017.03.26..
 */
public class WordGroupCategoryDTO implements java.io.Serializable {
    private long id;
    private String category;

    public WordGroupCategoryDTO(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public WordGroupCategoryDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordGroupCategoryDTO that = (WordGroupCategoryDTO) o;

        if (id != that.id) return false;
        return category != null ? category.equals(that.category) : that.category == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
