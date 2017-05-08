package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.04.22..
 */
import hu.unideb.inf.enums.NewMailStatus;

import javax.persistence.*;

@Entity
@Table(name="new_mail", schema="mydictionary")
public class NewMailEntity implements java.io.Serializable{
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private UserDataEntity id;

    @Column(name = "mail", nullable = false, length = 255)
    private String mail;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private NewMailStatus status;

    public NewMailEntity(UserDataEntity id, String mail, NewMailStatus status) {
        this.id = id;
        this.mail = mail;
        this.status = status;
    }

    public NewMailEntity() {
    }

    public UserDataEntity getId() {
        return id;
    }

    public void setId(UserDataEntity id) {
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

        NewMailEntity that = (NewMailEntity) o;

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
