package hu.unideb.inf.service.domain;

/**
 * Created by tothd on 2017. 05. 23..
 */
public class CreateGroupDTO {

    int id;
    String name;

    public CreateGroupDTO() {
    }

    public CreateGroupDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
