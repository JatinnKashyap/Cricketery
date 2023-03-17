package CricketGame.Repository.SQLRepository;

import CricketGame.Entity.SQLEntity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity,Long> {
    //use mysql repository
}