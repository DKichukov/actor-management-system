package role.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import role.models.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
