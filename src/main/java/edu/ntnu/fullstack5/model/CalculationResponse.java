package edu.ntnu.fullstack4java.model;

public class CalculationResponse {
  private boolean success;
  private double result;
  private String message;

  // Constructors
  public CalculationResponse(boolean success, double result) {
    this.success = success;
    this.result = result;
    this.message = "";
  }

  public CalculationResponse(boolean success, String message) {
    this.success = success;
    this.result = 0;
    this.message = message;
  }

  // Getters and Setters
  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public double getResult() {
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
