package hu.unideb.inf.service.domain;

/**
 * Created by varadi on 2017.03.26..
 */
public class LanguageDTO implements java.io.Serializable{
    private long id;
    private String name;

    public LanguageDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public LanguageDTO() {

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

        LanguageDTO that = (LanguageDTO) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LanguageDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
