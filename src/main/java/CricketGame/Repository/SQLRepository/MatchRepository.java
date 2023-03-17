package CricketGame.Repository.SQLRepository;

import CricketGame.Entity.SQLEntity.MatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<MatchEntity,Long> {
}
