package edu.ntnu.fullstack5.model;

import org.springframework.data.annotation.Id;

public class User {
  @Id
  String Username;
  String Password;

  public User(String username, String password) {
    username = this.Username;
    password = this.Password;
  }
}
