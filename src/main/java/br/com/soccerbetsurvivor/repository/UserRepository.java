package br.com.soccerbetsurvivor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.soccerbetsurvivor.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
