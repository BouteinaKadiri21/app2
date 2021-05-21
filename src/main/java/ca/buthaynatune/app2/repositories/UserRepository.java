package ca.buthaynatune.app2.repositories;

import ca.buthaynatune.app2.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
