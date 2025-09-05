package com.michaelspringproject.store.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "access")
    private String access;

    @Column(name = "email_address", unique = true)
    private String email_address;
    @Column(name = "password")
    private String password;

    // Constructors
    public Users() {

    }

    public Users(Long id, String fullnmame, String username, String email_address, String access , String password) {
        this.id = id;
        this.fullname = fullnmame;
        this.username = username;
        this.email_address = email_address;
        this.access = access;   
        this.password = password;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email_address) {
        this.email_address = email_address;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAccess(String access) {
        this.access = access;
    }

    //GETTERS
    public Long getId() {
        return id;
    }
    public String getFullname() {
        return fullname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
            return email_address;
        }
    public String getAccess() {
        return access;
    }

    
}
