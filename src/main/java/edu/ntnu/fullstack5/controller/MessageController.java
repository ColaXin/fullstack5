package edu.ntnu.fullstack4java.controller;

import edu.ntnu.fullstack4java.model.Calculation;
import edu.ntnu.fullstack4java.model.CalculationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/calculator")
public class MessageController {

  private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

  @PostMapping("/evaluate")
  public CalculationResponse calculate(@RequestBody ExpressionDTO expressionDTO) {
    String expressionString = expressionDTO.getExpression();
    logger.info("Request received: " + expressionString);
    if (expressionString == null || expressionString.trim().equals("")) {
      logger.error("No expression provided");
      return new CalculationResponse(false, "Error: No expression provided");
    }
    try {
      Expression exp = new ExpressionBuilder(expressionString).build();
      double evaluation = exp.evaluate();
      logger.info("Expression evaluated successfully: {} = {}", expressionString, evaluation);
      Calculation savedCalculation = new Calculation(expressionString, evaluation, true);
      return new CalculationResponse(true, evaluation);
    } catch (Exception e) {
      logger.error("Error processing expression: {}", expressionString, e);
      Calculation savedCalculation = new Calculation(expressionString, 0, false);
      return new CalculationResponse(false, "Error processing expression: " + expressionString);
    }
  }
}
