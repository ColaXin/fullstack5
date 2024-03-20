package edu.ntnu.fullstack5.repository;

import edu.ntnu.fullstack5.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<AppUser, Long> {
  List<AppUser> findAppUserById(Long id);
  AppUser findAppUserByUsernameAndPassword(String username, String password);
}
