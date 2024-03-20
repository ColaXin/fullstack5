package edu.ntnu.fullstack5.controller.DTOs;

public class LoginDTO {
  private String username;
  private String password;

  // No-args constructor
  public LoginDTO() {}

  // All-args constructor
  public LoginDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Getters and Setters
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

  // toString method for logging
  @Override
  public String toString() {
    return "LoginDTO{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}