package edu.ntnu.fullstack5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class AppUser {
  @Id
  @GeneratedValue
  private Long id;

  public AppUser(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public AppUser() {

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

  private String username;
  private String password;


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }




  @Override
  public String toString() {
    return "AppUser{" +
        "id=" + id +
        ", Username='" + username + '\'' +
        ", Password='" + password + '\'' +
        '}';
  }
}
