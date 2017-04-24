package hu.unideb.inf.service.domain;

import hu.unideb.inf.enums.NewMailStatus;

/**
 * Created by varadi on 2017.04.22..
 */
public class NewMailDTO implements java.io.Serializable{
    private UserDataDTO id;
    private String mail;
    private NewMailStatus status;

    public NewMailDTO(UserDataDTO id, String mail, NewMailStatus status) {
        this.id = id;
        this.mail = mail;
        this.status = status;
    }

    public NewMailDTO() {
    }

    public UserDataDTO getId() {
        return id;
    }

    public void setId(UserDataDTO id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public NewMailStatus getStatus() {
        return status;
    }

    public void setStatus(NewMailStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewMailDTO that = (NewMailDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return mail != null ? mail.equals(that.mail) : that.mail == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }
}
