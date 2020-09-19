package br.com.soccerbetsurvivor.repository;

import br.com.soccerbetsurvivor.model.Championship;
import br.com.soccerbetsurvivor.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends CrudRepository<Championship, Long>{

}
