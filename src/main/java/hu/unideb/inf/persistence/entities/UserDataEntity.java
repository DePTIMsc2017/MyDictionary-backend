package hu.unideb.inf.persistence.entities;

/**
 * Created by varadi on 2017.03.25..
 */
import hu.unideb.inf.enums.UserEvent;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_data", schema="mydictionary")
public class UserDataEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "ip", nullable = false, length = 39)
    private String ip;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", nullable = false)
    private Date time;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", nullable = false)
    private UserEvent event;

    @Column(name = "data", length = 255)
    private String data;

    public UserDataEntity() {
    }

    public UserDataEntity(long id, UserEntity user, String ip, Date time, UserEvent event, String data) {
        this.id = id;
        this.user = user;
        this.ip = ip;
        this.time = time;
        this.event = event;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public UserEvent getEvent() {
        return event;
    }

    public void setEvent(UserEvent event) {
        this.event = event;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDataEntity that = (UserDataEntity) o;

        if (id != that.id) return false;
        if (!user.equals(that.user)) return false;
        if (!ip.equals(that.ip)) return false;
        if (!time.equals(that.time)) return false;
        if (event != that.event) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + ip.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + event.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDataEntity{" +
                "user=" + user +
                ", ip='" + ip + '\'' +
                ", time=" + time +
                ", event=" + event +
                ", data='" + data + '\'' +
                '}';
    }
}
