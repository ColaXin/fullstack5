package edu.ntnu.fullstack5;

import edu.ntnu.fullstack5.model.AppUser;
import edu.ntnu.fullstack5.model.Calculation;
import edu.ntnu.fullstack5.repository.CalculationRepository;
import edu.ntnu.fullstack5.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Fullstack5Application {

  public static void main(String[] args) {
    SpringApplication.run(Fullstack5Application.class, args);
  }

  @Bean
  public CommandLineRunner run(UserRepository repo, CalculationRepository calcRepo) {
    return (args -> {
      //testInsert2(repo, calcRepo);
      //System.out.println(repo.findAppUserByUsernameContaining("testepetter"));
    });
  }



private void testInsert(UserRepository repo){
    repo.save(new AppUser("testepetter","testemann"));
    repo.save(new AppUser("testegutt","jeggriner"));
}

private void testInsert2(UserRepository userRepo, CalculationRepository repo) {
    AppUser User1 = new AppUser("ariMAMAN", "rastafarian");
    userRepo.save(User1);
    AppUser User2 = new AppUser("Sondrepus", "kattenBetaler");
    userRepo.save(User2);
    repo.save(new Calculation("2+2","4",true,User1));
    repo.save(new Calculation("10+10","20",true,User2));

}

}
