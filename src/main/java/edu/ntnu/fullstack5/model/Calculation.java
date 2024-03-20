package edu.ntnu.fullstack4java.model;

public class Calculation {
  String Expression;
  double Calculated;
  boolean valid;

  public Calculation(String expression, double calculated, boolean valid) {
    expression = this.Expression;
    calculated = this.Calculated;
    valid = this.valid;
  }
}
