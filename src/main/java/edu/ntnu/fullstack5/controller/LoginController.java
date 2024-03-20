package edu.ntnu.fullstack5.controller;

import edu.ntnu.fullstack5.repository.CalculationRepository;
import edu.ntnu.fullstack5.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class LoginController {
  @Autowired
  UserRepository UserRepo;
  private static final Logger logger = LoggerFactory.getLogger(MessageController.class);


}
