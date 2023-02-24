package CricketGame.Repository;

import CricketGame.Entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
}
