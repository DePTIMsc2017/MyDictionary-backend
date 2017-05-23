package hu.unideb.inf.service.domain;

import hu.unideb.inf.enums.UserStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by tothd on 2017. 05. 22..
 */
public class UserWithPassDTO extends UserDTO {


    private String currentPassword;


    public UserWithPassDTO() {

    }

    public UserWithPassDTO(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public UserWithPassDTO(long id, String username, String password, String mail, String birthDate, LanguageDTO defaultLanguage, UserStatus status, Date registrationDate, String country, String city, Boolean newsletter, Integer maxWordGroup, Integer maxWordInGroup, List<RoleDTO> roles, String currentPassword) {
        super(id, username, password, mail, birthDate, defaultLanguage, status, registrationDate, country, city, newsletter, maxWordGroup, maxWordInGroup, roles);
        this.currentPassword = currentPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
