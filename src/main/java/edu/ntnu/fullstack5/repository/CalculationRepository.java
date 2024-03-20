package edu.ntnu.fullstack5.repository;

import edu.ntnu.fullstack5.model.Calculation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, Long> {
List<Calculation> getCalculationsByUserId(Long id);
}
