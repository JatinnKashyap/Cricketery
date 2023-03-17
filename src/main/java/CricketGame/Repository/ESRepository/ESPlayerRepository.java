package CricketGame.Repository.ESRepository;

import CricketGame.Entity.ESEntity.PlayerESEntity;
import CricketGame.Entity.SQLEntity.PlayerEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESPlayerRepository extends ElasticsearchRepository<PlayerESEntity,Long> {
}
