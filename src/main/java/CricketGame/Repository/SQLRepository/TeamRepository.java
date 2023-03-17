package CricketGame.Repository.SQLRepository;

import CricketGame.Entity.SQLEntity.TeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity,Long> {
}
