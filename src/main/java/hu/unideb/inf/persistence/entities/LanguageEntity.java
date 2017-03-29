package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.03.25..
 */

import javax.persistence.*;

@Entity
@Table(name="language", schema="mydictionary", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class LanguageEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    public LanguageEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public LanguageEntity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageEntity that = (LanguageEntity) o;

        if (id != that.id) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LanguageEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
