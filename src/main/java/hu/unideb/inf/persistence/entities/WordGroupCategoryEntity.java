package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.03.26..
 */

import javax.persistence.*;

@Entity
@Table(name="word_group_category", schema="mydictionary", uniqueConstraints = @UniqueConstraint(columnNames = "category"))
public class WordGroupCategoryEntity  implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "category", nullable = false, length = 255)
    private String category;

    public WordGroupCategoryEntity(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public WordGroupCategoryEntity() {
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

        WordGroupCategoryEntity that = (WordGroupCategoryEntity) o;

        if (id != that.id) return false;
        return category.equals(that.category);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WordGroupCategoryEntity{" +
                "category='" + category + '\'' +
                '}';
    }
}
