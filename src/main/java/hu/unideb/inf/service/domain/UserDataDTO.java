package hu.unideb.inf.service.domain;

import hu.unideb.inf.enums.UserEvent;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by varadi on 2017.03.26..
 */
public class UserDataDTO implements Serializable{
    private long id;
    private UserDTO user;
    private String ip;
    private Date time;
    private UserEvent event;
    private String data;

    public UserDataDTO() {
    }

    public UserDataDTO(long id, UserDTO user, String ip, Date time, UserEvent event, String data) {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
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

        UserDataDTO that = (UserDataDTO) o;

        if (id != that.id) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (event != that.event) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
