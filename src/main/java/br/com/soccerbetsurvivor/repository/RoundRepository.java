package br.com.soccerbetsurvivor.repository;

import br.com.soccerbetsurvivor.model.Round;
import br.com.soccerbetsurvivor.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository<Round, Long>{

}
