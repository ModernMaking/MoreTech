package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class User implements Serializable{

    public enum UserType {
        WORKER,
        LEADER,
        ADMIN
    };

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    private String password;


    private String nickName;

    private UserType userType;

    private String firstName;

    private String secondName;

    private String privateKey;

    private String publicKey;


    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String nickName, String password, UserType userType)
    {
        this.nickName=nickName;
        this.password=password;
        this.userType=userType;
    }

    public User(String nickName, String password, String firstName, String secondName)
    {
        this.nickName=nickName;
        this.password=password;
        this.firstName=firstName;
        this.secondName=secondName;
        this.userType=UserType.WORKER;
    }

    public static User createAdmin(String nickName, String password, String firstName, String secondName)
    {
        User u = new User();
        u.nickName=nickName;
        u.password=password;
        u.firstName=firstName;
        u.secondName=secondName;
        u.userType=UserType.ADMIN;
        return u;
    }

    public String getPassword()
    {
        return password;
    }

    public String getNickName()
    {
        return nickName;
    }

    public UserType getUserType()
    {
        return userType;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
