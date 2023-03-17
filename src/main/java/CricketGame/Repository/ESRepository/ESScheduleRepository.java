package CricketGame.Repository.ESRepository;

import CricketGame.Entity.ESEntity.ScheduleESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESScheduleRepository extends ElasticsearchRepository<ScheduleESEntity, Long> {
}
