package CricketGame.Repository;

import CricketGame.Entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity,Long> {
}
