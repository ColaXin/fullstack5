package edu.ntnu.fullstack5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Calculation {
  @Id
  @GeneratedValue
  private Long id;

  private String expression;
  private String result;
  private boolean valid;

  @ManyToOne
  @JoinColumn(name = "app_user_id")
  private AppUser user;

  // Constructors
  public Calculation() {
  }

  public Calculation(String expression, String result, boolean valid, AppUser user) {
    this.expression = expression;
    this.result = result;
    this.valid = valid;
    this.user = user;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }
}
