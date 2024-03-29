package CricketGame.Repository.SQLRepository;

import CricketGame.Entity.SQLEntity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
}
