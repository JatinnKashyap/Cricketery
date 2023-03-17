package CricketGame.Repository.ESRepository;

import CricketGame.Entity.ESEntity.MatchESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESMatchRepository extends ElasticsearchRepository<MatchESEntity, Long> {
}
