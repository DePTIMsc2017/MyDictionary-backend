package hu.unideb.inf.persistence.entities;

import hu.unideb.inf.enums.UserStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mates on 2017. 03. 22..
 */
@Entity
@Table(name="user", schema="mydictionary", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class UserEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name", nullable = false, length = 255)
    private String username;

    @Column(name = "user_pwd", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "default_language")
    private LanguageEntity defaultLanguage;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private UserStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "country", length = 255)
    private String country;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "newsletter", nullable = false)
    private Boolean newsletter;

    @Column(name = "max_word_group", nullable = false)
    private Integer maxWordGroup;

    @Column(name = "max_word_in_group", nullable = false)
    private Integer maxWordInGroup;

    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
    private List<RoleEntity> roles;

    @ManyToMany
    @JoinTable(
            name="shared_word_group",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="word_group_id", referencedColumnName="id"))
    private List<WordGroupEntity> sharedWordGroups;

    @OneToMany(mappedBy="user")
    private List<SearchedWordEntity> searchedWords;

    public UserEntity() {
    }

    public UserEntity(long id, String username, String password, String mail, Date birthDate, LanguageEntity defaultLanguage, UserStatus status, Date registrationDate, String country, String city, Boolean newsletter, Integer maxWordGroup, Integer maxWordInGroup) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = mail;
        this.birthDate = birthDate;
        this.defaultLanguage = defaultLanguage;
        this.status = status;
        this.registrationDate = registrationDate;
        this.country = country;
        this.city = city;
        this.newsletter = newsletter;
        this.maxWordGroup = maxWordGroup;
        this.maxWordInGroup = maxWordInGroup;
    }

    @PrePersist
    void preInsert() {
        this.status=UserStatus.ACTIVE;
        this.registrationDate = new Date();
        this.newsletter = false;
        this.maxWordGroup = 50;
        this.maxWordInGroup = 10;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public LanguageEntity getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(LanguageEntity defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public Integer getMaxWordGroup() {
        return maxWordGroup;
    }

    public void setMaxWordGroup(Integer maxWordGroup) {
        this.maxWordGroup = maxWordGroup;
    }

    public Integer getMaxWordInGroup() {
        return maxWordInGroup;
    }

    public void setMaxWordInGroup(Integer maxWordInGroup) {
        this.maxWordInGroup = maxWordInGroup;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<WordGroupEntity> getSharedWordGroups() {
        return sharedWordGroups;
    }

    public void setSharedWordGroups(List<WordGroupEntity> sharedWordGroups) {
        this.sharedWordGroups = sharedWordGroups;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (!username.equals(that.username)) return false;
        return registrationDate.equals(that.registrationDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + username.hashCode();
        result = 31 * result + registrationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                '}';
    }
}
