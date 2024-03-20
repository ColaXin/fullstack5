  package edu.ntnu.fullstack5.controller;

  import edu.ntnu.fullstack5.controller.DTOs.LoginDTO;
  import edu.ntnu.fullstack5.model.AppUser;
  import edu.ntnu.fullstack5.model.Calculation;
  import edu.ntnu.fullstack5.repository.CalculationRepository;
  import edu.ntnu.fullstack5.repository.UserRepository;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.ResponseEntity;
  import org.springframework.stereotype.Service;
  import org.springframework.web.bind.annotation.*;

  import java.util.List;

  @CrossOrigin(origins = "http://localhost:3000")
  @RestController
  @RequestMapping("/calculations")
  @Service
  public class ListController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    CalculationRepository calcRepo;

    @PostMapping("/login")
    public ResponseEntity<List<Calculation>> login(@RequestBody LoginDTO loginDTO) {
      // Here, you would add your authentication logic
      AppUser loggedUser= userRepo.findAppUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
      if (loggedUser == null) {
        return null;
      }
      List<Calculation> calculations = calcRepo.getCalculationsByUserId(loggedUser.getId());

      // For the sake of the example, return a simple message
      return ResponseEntity.ok(calculations);
    }
  }
