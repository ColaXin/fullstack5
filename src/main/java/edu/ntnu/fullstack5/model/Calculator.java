package edu.ntnu.fullstack5.model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class Calculator {

  public CalculationResponse calculate(String expressionString) {
    if (expressionString == null || expressionString.trim().equals("")) {
      return new CalculationResponse(false, "Error: No expression provided");
    }
    try {
      net.objecthunter.exp4j.Expression exp = new ExpressionBuilder(expressionString).build();
      double evaluation = exp.evaluate();
      return new CalculationResponse(true, evaluation);

    } catch (Exception e) {
      return new CalculationResponse(false, "Error processing expression: " + expressionString);
    }
  }
}
