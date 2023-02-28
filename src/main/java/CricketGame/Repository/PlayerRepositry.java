package CricketGame.Repository;

import CricketGame.Entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepositry extends CrudRepository<PlayerEntity,Long> {
    //use mysql repository
}
