package CricketGame.Repository;

import CricketGame.Entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity,Long> {
}
