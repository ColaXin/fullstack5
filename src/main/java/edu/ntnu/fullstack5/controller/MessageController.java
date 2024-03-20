package edu.ntnu.fullstack5.controller;


import edu.ntnu.fullstack5.controller.DTOs.ExpressionDTO;
import edu.ntnu.fullstack5.model.AppUser;
import edu.ntnu.fullstack5.model.Calculation;
import edu.ntnu.fullstack5.model.CalculationResponse;
import edu.ntnu.fullstack5.model.Calculator;
import edu.ntnu.fullstack5.repository.CalculationRepository;
import edu.ntnu.fullstack5.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/calculator")
@Service
public class MessageController {

  Calculator calculator = new Calculator();

  String username = "Ari";
  String password = "test2";
  @Autowired
  private UserRepository userRepo;
  @Autowired
  CalculationRepository calcRepo;
  private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

  @PostMapping("/evaluate")
  public CalculationResponse calculate(@RequestBody ExpressionDTO expressionDTO) {
    String expressionString = expressionDTO.getExpression();

    AppUser user = userRepo.findAppUserByUsernameAndPassword(expressionDTO.getUsername(), expressionDTO.getPassword());

    if (user == null) {
      userRepo.save(new AppUser(username,password));
      user = userRepo.findAppUserByUsernameAndPassword(username,password);
    }

    CalculationResponse response = calculator.calculate(expressionString);
    Calculation savedCalculation;
    if (response.isSuccess()) {
      savedCalculation = new Calculation(expressionString, String.valueOf(response.getResult()),response.isSuccess(),user);
    } else {
      savedCalculation = new Calculation(expressionString, response.getMessage(),response.isSuccess(),user);
    }
    calcRepo.save(savedCalculation);
    System.out.println(calcRepo.getCalculationsByUserId(user.getId()));
    return response;
  }
}
