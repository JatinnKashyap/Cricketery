package CricketGame.Repository.ESRepository;

import CricketGame.Entity.ESEntity.TeamESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESTeamRepository extends ElasticsearchRepository<TeamESEntity, Long> {
}
