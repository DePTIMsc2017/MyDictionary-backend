package hu.unideb.inf.service.domain;

/**
 * Created by varadi on 2017.03.26..
 */
public class RoleDTO implements java.io.Serializable{
    private long id;
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(long id, String name) {
        this.id = id;
        this.name = name;
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

        RoleDTO roleDTO = (RoleDTO) o;

        if (id != roleDTO.id) return false;
        return name != null ? name.equals(roleDTO.name) : roleDTO.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
