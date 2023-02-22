package CricketGame.Repository;

import CricketGame.Entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepositry extends CrudRepository<PlayerEntity,Long> {
    //use mysql repository
}
